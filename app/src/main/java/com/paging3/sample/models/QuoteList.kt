package com.paging3.sample.models

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Data>,
    val totalCount: Int,
    val totalPages: Int
)