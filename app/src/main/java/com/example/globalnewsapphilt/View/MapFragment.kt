package com.example.globalnewsapphilt.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.globalnewsapphilt.R
import com.example.globalnewsapphilt.Utilities.CountryLocations
import com.example.globalnewsapphilt.Utilities.MyEnum
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

class MapFragment: BaseFragment(), OnMarkerClickListener, OnMapClickListener, OnMapReadyCallback
{

    private val binding: FragmentMapItemBinding  by lazy{
        FragmentMapItemBinding.inflate(layoutInflater)
    }

    private val countryLocations: CountryLocations = CountryLocations()
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

//                it.uiSettings.isZoomControlsEnabled()

                provideMarkers(it)

               onMapReady(it)
            }
     return rootView
    }





    private fun provideMarkers(map: GoogleMap) {

              map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ae)
                        .title("United Arab Emirates")
                        .flat(true)
                    )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ar)
                        .title("Argentina")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.at)
                        .title("Austria")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.at)
                        .title("Austria")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.au)
                        .title("Australia")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.BE)
                        .title("Belgium")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.bg)
                        .title("Bulgaria")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.br)
                        .title("Brazil")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ca)
                        .title("Canada")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ch)
                        .title("Switzerland")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.cn)
                        .title("China")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.co)
                        .title("Colombia")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.cu)
                        .title("Cuba")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.cz)
                        .title("Czech Republic")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.de)
                        .title("Germany")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.eg)
                        .title("Egypt")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.fr)
                        .title("France")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.gb)
                        .title("United Kingdom")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.gr)
                        .title("Greece")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.hk)
                        .title("Hong Kong")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.hu)
                        .title("Hungary")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ID)
                        .title("Indonesia")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ie)
                        .title("Ireland")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.il)
                        .title("Israel")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.IN)
                        .title("India")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.it)
                        .title("Italy")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.jp)
                        .title("Japan")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.kr)
                        .title("South Korea")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.lt)
                        .title("Lithuania")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.lv)
                        .title("Latvia")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ma)
                        .title("Morocco")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.mx)
                        .title("Mexico")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.my)
                        .title("Malaysia")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ng)
                        .title("Nigeria")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.nl)
                        .title("Netherlands")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.no)
                        .title("Norway")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.nz)
                        .title("New Zealand")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ph)
                        .title("Philippines")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.pl)
                        .title("Poland")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.pt)
                        .title("Portugal")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ro)
                        .title("Romania")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.rs)
                        .title("Serbia")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ru)
                        .title("Russia")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.sa)
                        .title("Saudi Arabia")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.se)
                        .title("Sweden")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.sg)
                        .title("Singapore")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.si)
                        .title("Slovenia")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.sk)
                        .title("Slovakia")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.th)
                        .title("Thailand")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.tr)
                        .title("Turkey")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.tw)
                        .title("Taiwan")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ua)
                        .title("Ukraine")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.us)
                        .title("United States")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.ve)
                        .title("Venezuela")
                        .flat(true)
                )

                map.addMarker(
                    MarkerOptions()
                        .position(countryLocations.za)
                        .title("South Africa")
                        .flat(true)
                )
            }

    override fun onMarkerClick(p0: Marker): Boolean {
        val country = p0.title
        //val coordinate = LatLng(p0.position.latitude, p0.position.longitude)
        //map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 12f), 21000, null)

        clickCountry(country)


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


    private fun clickCountry(country: String? = null){

        when(country){

            "United Arab Emirates" -> {
                newsViewModel.getNews(country = "ae")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Argentina" -> {
                newsViewModel.getNews(country = "ar")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Austria" -> {
                newsViewModel.getNews(country = "at")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Australia" -> {
                newsViewModel.getNews(country = "au")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Belgium" -> {
                newsViewModel.getNews(country = "be")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Bulgaria" -> {
                newsViewModel.getNews(country = "bg")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Brazil" -> {
                newsViewModel.getNews(country = "br")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Canada" -> {
                newsViewModel.getNews(country = "ca")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "China" -> {
                newsViewModel.getNews(country = "cn")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Switzerland" -> {
                newsViewModel.getNews(country = "ch")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Colombia" -> {
                newsViewModel.getNews(country = "co")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Cuba" -> {
                newsViewModel.getNews(country = "cu")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Czech Republic" -> {
                newsViewModel.getNews(country = "cz")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Germany" -> {
                newsViewModel.getNews(country = "de")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Eygpt" -> {
                newsViewModel.getNews(country = "eg")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "France" -> {
                newsViewModel.getNews(country = "fr")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "United Kingdom" -> {
                newsViewModel.getNews(country = "gb")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Greece" -> {
                newsViewModel.getNews(country = "gr")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Hong Kong" -> {
                newsViewModel.getNews(country = "hk")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Hungary" -> {
                newsViewModel.getNews(country = "hu")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Indonesia" -> {
                newsViewModel.getNews(country = "id")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Israel" -> {
                newsViewModel.getNews(country = "ie")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Italy" -> {
                newsViewModel.getNews(country = "il")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Japan" -> {
                newsViewModel.getNews(country = "jp")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "South Korea" -> {
                newsViewModel.getNews(country = "kr")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Lithuania" -> {
                newsViewModel.getNews(country = "lt")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Latvia" -> {
                newsViewModel.getNews(country = "lv")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Morocco" -> {
                newsViewModel.getNews(country = "ma")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Mexico" -> {
                newsViewModel.getNews(country = "mx")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Malaysia" -> {
                newsViewModel.getNews(country = "my")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Nigeria" -> {
                newsViewModel.getNews(country = "ng")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Netherlands" -> {
                newsViewModel.getNews(country = "nl")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Norway" -> {
                newsViewModel.getNews(country = "no")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "New Zealand" -> {
                newsViewModel.getNews(country = "nz")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Philippines" -> {
                newsViewModel.getNews(country = "ph")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Poland" -> {
                newsViewModel.getNews(country = "pl")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Portugal" -> {
                newsViewModel.getNews(country = "pt")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Romania" -> {
                newsViewModel.getNews(country = "ro")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Serbia" -> {
                newsViewModel.getNews(country = "rs")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Russia" -> {
                newsViewModel.getNews(country = "ru")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Saudi Arabia" -> {
                newsViewModel.getNews(country = "sa")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Sweden" -> {
                newsViewModel.getNews(country = "se")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Singapore" -> {
                newsViewModel.getNews(country = "sg")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Slovenia" -> {
                newsViewModel.getNews(country = "si")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Slovakia" -> {
                newsViewModel.getNews(country = "sk")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Thailand" -> {
                newsViewModel.getNews(country = "th")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Turkey" -> {
                newsViewModel.getNews(country = "tr")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Taiwan" -> {
                newsViewModel.getNews(country = "tw")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Ukraine" -> {
                newsViewModel.getNews(country = "ua")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "United States" -> {
                newsViewModel.getNews(country = "us")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "Venezuela" -> {
                newsViewModel.getNews(country = "ve")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
            "South Africa" -> {
                newsViewModel.getNews(country = "za")
                findNavController().navigate(R.id.action_menu_map_to_menu_home)
            }
        }
    }


}

