package com.yuwin.hotelapp_v2.util

import com.yuwin.hotelapp_v2.R


data class PopularHotels(
    val img: Int,
    val name: String
)

data class RecommendedHotels(
    val img: Int,
    val name: String,
    val price: String,
    val location: String
)

data class Booking(
    val img: Int,
    val name: String,
    val guestNumber: Int,
    val location: String,
    val from: String,
    val to: String
)

data class SearchResults(
    val img: Int,
    val name: String,
    val price: String,
    val location: String,
    val ratings: String
)

val searchResultList = listOf(
    SearchResults(
        img = R.drawable.r_hotel_1,
        name = "Golden Star Beach Hotel",
        price = "$50 per person",
        location = "163 Lewis Place, 11500 Negombo, Sri Lanka",
        ratings = "4.7"
    ),
    SearchResults(
        img = R.drawable.r_hotel_2,
        name = "Regal Réseau Hotel & Spa",
        price = "$100 per person",
        location = "No.06, Carron Place, 11500 Negombo, Sri Lanka",
        ratings = "4.6"
    ),
    SearchResults(
        img = R.drawable.r_hotel_3,
        name = "Inspira ella",
        price = "$90 per person",
        location = "Inspira ella, 1st lane, sapumalthena, ella, 90900 Ella, Sri Lanka",
        ratings = "4.8"
    ),
    SearchResults(
        img = R.drawable.r_hotel_4,
        name = "Salt Mirissa",
        price = "$60 per person",
        location = "No 220/8 Liyanaralagawatta Udupila, Mirissa, 81740 Mirissa, Sri Lanka",
        ratings = "4.6"
    ),
    SearchResults(
        img = R.drawable.hotel_5,
        name = "Atha Hotel",
        price = "$70 per person",
        location = "No 48/4, Atha Hotel, Anuradhapura, Sri Lanka",
        ratings = "4.5"
    ),
    SearchResults(
        img = R.drawable.hotel_2,
        name = "Gall Fort Hotel",
        price = "$90 per person",
        location = "Gall Fort, Galle, Sri Lanka",
        ratings = "4.8"
    )

)

val bookingList = listOf(
    Booking(
        img = R.drawable.b_hotel_1,
        name = "98 Acres Hotel",
        guestNumber = 2,
        location = "98 Acres Resort & Spa Greenland Estate, Passara, Namunukula Road, Ella, 90090 Ella",
        from = "28 Oct 2022",
        to = "31 Oct 2022"
    )
)

val recommendedHotels = listOf(
    RecommendedHotels(
        img = R.drawable.r_hotel_1,
        name = "Golden Star Beach Hotel",
        price = "$50 per person",
        location = "163 Lewis Place, 11500 Negombo, Sri Lanka"
    ),
    RecommendedHotels(
        img = R.drawable.r_hotel_2,
        name = "Regal Réseau Hotel & Spa",
        price = "$100 per person",
        location = "No.06, Carron Place, 11500 Negombo, Sri Lanka"
    ),
    RecommendedHotels(
        img = R.drawable.r_hotel_3,
        name = "Inspira ella",
        price = "$90 per person",
        location = "Inspira ella, 1st lane, sapumalthena, ella, 90900 Ella, Sri Lanka"
    ),
    RecommendedHotels(
        img = R.drawable.r_hotel_4,
        name = "Salt Mirissa",
        price = "$60 per person",
        location = "No 220/8 Liyanaralagawatta Udupila, Mirissa, 81740 Mirissa, Sri Lanka"
    )

)

val popularHotels = listOf(
    PopularHotels(
        img = R.drawable.hotel_1,
        name = "98 Acres Resort"
    ),
    PopularHotels(
        img = R.drawable.hotel_2,
        name = "Gall Fort Hotel"
    ),
    PopularHotels(
        img = R.drawable.hotel_3,
        name = "The Secret Elle"
    ),
    PopularHotels(
        img = R.drawable.hotel_4,
        name = "Granbell Hotel Colombo"
    ),
    PopularHotels(
        img = R.drawable.hotel_5,
        name = "Atha Hotel"
    )

)