package net.maiatoday.helloblondie

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import net.maiatoday.helloblondie.data.Api
import net.maiatoday.helloblondie.data.Model
import net.maiatoday.permissions.AppPermission
import net.maiatoday.permissions.handlePermission
import net.maiatoday.permissions.requestPermission
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            doSearchWithPermissionCheck()

        }

        buttonCallMe.setOnClickListener {
            val searchString = editSearchString.text.toString()
            doSearch(searchString)
        }
    }

    private fun doSearchWithPermissionCheck() {
        handlePermission(AppPermission.WRITE_EXTERNAL_STORAGE,
                {
                    val searchString = editSearchString.text.toString()
                    doSearch(searchString)
                },
                { requestPermission(it) },
                { snackbarWithAction(contentView, it.explanationMessageId) { requestPermission(it) } })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun doSearch(searchString: String) {
        if (!searchString.isEmpty()) {
            val call = Api.create().hitCountCheck("query", "json", "search", searchString)
            call.enqueue(object : Callback<Model.Result> {
                override fun onResponse(call: Call<Model.Result>?, response: Response<Model.Result>?) {
                    val result = response?.body() as Model.Result
                    txtAnytime.text = result.query.search[0].title + " hitcount=" + result.query.searchinfo.totalhits + " pageId=" + result.query.search[0].pageid
                }

                override fun onFailure(call: Call<Model.Result>?, t: Throwable?) {
                    txtAnytime.text = "oops"
                }
            })

        }
    }

    fun snackbarWithAction(view: View, messageId: Int, actionText: Int = R.string.request_permission, action: () -> Unit) {
        Snackbar.make(view, messageId, Snackbar.LENGTH_LONG)
                .setAction(actionText) { action() }
                .show()
    }
}
