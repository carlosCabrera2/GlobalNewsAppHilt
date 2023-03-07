package com.example.globalnewsapphilt.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.globalnewsapphilt.R
import com.example.globalnewsapphilt.databinding.FragmentMapItemBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment: BaseFragment(),
    OnMapReadyCallback,
    GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMapClickListener {

    private val binding: FragmentMapItemBinding  by lazy{
        FragmentMapItemBinding.inflate(layoutInflater)
    }

//    private lateinit var mapFragment: SupportMapFragment

    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_map_item, container,false)

        val mapFragment = childFragmentManager
                         .findFragmentById(R.id.mapFragment) as SupportMapFragment?

        mapFragment!!.getMapAsync{

            it.mapType = GoogleMap.MAP_TYPE_NORMAL

            // clears markers
            it.clear()

            val googlePlex = CameraPosition.builder()
                        .target(LatLng(0.0,0.0))
                        .zoom(2f)
                        .bearing(0f)
                        .tilt(45f)
                        .build()

            it.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex),
                            10000,
                            null
            )

            it.addMarker(
                MarkerOptions()
                    .position(LatLng(0.0,0.0))
                    .title("United States")
                    .snippet("Popular News from The United States")
            )
        }

     return rootView
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMapClickListener(this)
    }

    override fun onMyLocationButtonClick(): Boolean {
        return false
    }

    override fun onMapClick(p0: LatLng) {
       val coordinates = LatLng(p0.latitude, p0.longitude)
       val mapMarker = MarkerOptions().position(coordinates).title("News around me")
        map.clear()
        map.addMarker(mapMarker)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates,2f),
                        2000, null)
        newsViewModel.getNews()

    }
}