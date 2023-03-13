package com.example.globalnewsapphilt.Utilities

class NullNewsResponse(message: String = "The news response is null"): Exception(message)
class FailureResponse(message: String?) : Exception(message)
class NullSearchResponse(message: String= "Invalid search input. Please try another country," +
        " or retry the country starting with a capital Letter"): Exception(message)