package com.example.globalnewsapphilt.Utilities

class NullNewsResponse(message: String = "The news response is null"): Exception(message)
class FailureResponse(message: String?) : Exception(message)