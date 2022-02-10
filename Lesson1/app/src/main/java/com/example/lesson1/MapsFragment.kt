package com.example.lesson1

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.os.Build
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.fragment_maps.*
import java.io.IOException


class MapsFragment : Fragment() {
    private lateinit var map: GoogleMap
    private val markers: ArrayList<Marker> = arrayListOf()
    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap
        googleMap.setOnMapLongClickListener { latLng ->
            addMarkerToArray(latLng)
        }
        googleMap.setOnMarkerClickListener {marker->
            AlertDialog.Builder(requireContext())
                .setTitle("Выбор действия")
                .setMessage("Выберете действие")
                .setCancelable(false)
                .setNegativeButton("Отмена") { dialog, _ ->
                    dialog.cancel()
                }
                .setNeutralButton("Изменить маркер") { _, _ ->
                    val b = AlertDialog.Builder(requireContext())
                    val customLayout = layoutInflater.inflate(R.layout.change_marker, null);
                    b.setView(customLayout)
                    customLayout.findViewById<EditText>(R.id.name).setText(marker.title)
                    customLayout.findViewById<EditText>(R.id.latitude).setText(marker.position.latitude.toString())
                    customLayout.findViewById<EditText>(R.id.longitude).setText(marker.position.longitude.toString())
                    b.setPositiveButton("Ок"){_,_->
                        val name = customLayout.findViewById<EditText>(R.id.name).text.toString()
                        val latitude = customLayout.findViewById<EditText>(R.id.latitude).text.toString().toDouble()
                        val longitude = customLayout.findViewById<EditText>(R.id.longitude).text.toString().toDouble()
                        marker.remove()
                        map.addMarker(MarkerOptions()
                            .position(LatLng(latitude,longitude))
                            .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.ic_map_pin))
                            .title(name))
                    }
                    b.create().show()
                }
                .setPositiveButton("Удалить маркер") { _, _ ->
                    marker.remove()
                }
                .create()
                .show()
            true }
        activateMyLocation(googleMap)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                0
            )
        }
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as
                SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        initSearchByAddress()
    }
    private fun initSearchByAddress() {
        buttonAdd.setOnClickListener {
            val geoCoder = Geocoder(it.context)
            val searchText = searchAddress.text.toString()
            Thread {
                try {
                    val addresses = geoCoder.getFromLocationName(searchText, 1)
                    if (addresses.size > 0) {
                        goToAddress(addresses, it, searchText)
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }.start()
        }
    }
    private fun goToAddress(
        addresses: MutableList<Address>,
        view: View,
        searchText: String
    ) {
        val location = LatLng(
            addresses[0].latitude,
            addresses[0].longitude
        )
        view.post {
            map.addMarker(MarkerOptions()
                .position(location)
                .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.ic_map_marker))
                .title(searchText))
            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    location,
                    15f
                )
            )
        }
    }
    private fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
        val vectorDrawable = ContextCompat.getDrawable(context, vectorResId)
        vectorDrawable!!.setBounds(
            0,
            0,
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight
        )
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    private fun addMarkerToArray(location: LatLng) {
        val marker=map.addMarker(MarkerOptions()
            .position(location)
            .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.ic_map_pin))
            .title(markers.size.toString()))
        markers.add(marker!!)
    }

    private fun activateMyLocation(googleMap: GoogleMap) {
        context?.let {
            val isPermissionGranted =
                ContextCompat.checkSelfPermission(it,
                    Manifest.permission.ACCESS_FINE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED
            googleMap.isMyLocationEnabled = isPermissionGranted
            googleMap.uiSettings.isMyLocationButtonEnabled = isPermissionGranted
        }
//Получить разрешение, если его нет
    }
}
