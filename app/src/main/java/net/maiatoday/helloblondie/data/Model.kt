package net.maiatoday.helloblondie.data

/**
 * Created by maia on 2017/11/18.
 */
object Model {
    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo, val search: List<Search>)
    data class SearchInfo(val totalhits: Int)
    data class Search(val title: String, val pageid: Int)
}