package com.example.globalnewsapphilt.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.globalnewsapphilt.R
import com.example.globalnewsapphilt.Utilities.Countries

import com.example.globalnewsapphilt.Utilities.countryList
import com.example.globalnewsapphilt.databinding.FragmentMapItemBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMapClickListener
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import javax.annotation.meta.When

class MapFragment: BaseFragment(), OnMarkerClickListener, OnMapClickListener, OnMapReadyCallback {
    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val rootView = inflater.inflate(R.layout.fragment_map_item, container,false)
            val mapFragment = childFragmentManager
                                .findFragmentById(R.id.mapFragment) as SupportMapFragment?

            mapFragment?.getMapAsync{

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
                provideMarkers(it)
               onMapReady(it)
            }
     return rootView
    }


    override fun onMarkerClick(p0: Marker): Boolean {

            for (Countries in countryList) {
                if (p0.title == Countries.country) {
                    newsViewModel.getNews(country = Countries.countryCode)
                    findNavController().navigate(R.id.action_menu_map_to_menu_home,
                    bundleOf(Pair("CountryTitle", Countries.country))
                    )
                }
            }
        return false
    }

    override fun onMapClick(p0: LatLng) {
        val coordinate = LatLng(p0.latitude, p0.longitude)

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 15f), 2000, null)
    }

    override fun onMapReady(p0: GoogleMap) {

        map = p0
        map.setOnMarkerClickListener(this)
        map.setOnMapClickListener(this)
    }





    private fun provideMarkers(map: GoogleMap) {

      for (Countries in countryList) {
                    map.addMarker(
                        MarkerOptions()
                            .position(Countries.location)
                            .title(Countries.country)
                    )
        }
    }




}

