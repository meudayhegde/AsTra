package com.coleague.astra

import android.app.Dialog
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.*
import com.coleague.astra.adapters.LocationGridAdapter
import com.victor.loading.rotate.RotateLoading

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val login_dialog= Dialog(this,android.R.style.Theme_Light_NoTitleBar_Fullscreen)
        login_dialog.setContentView(R.layout.activity_login)
        login_dialog.setCancelable(false)
        login_dialog.show()

        val login_btn=login_dialog.findViewById<Button>(R.id.cirLoginButton)
        login_btn.setOnClickListener {
            login_dialog.dismiss()
            onLogin()
        }
    }

    fun onLogin(){
        setContentView(R.layout.asset_location)
        val location_grid=this.findViewById<GridView>(R.id.gridview_location)
        location_grid.adapter=LocationGridAdapter(arrayOf("A","B"), arrayOf("1","2","3","4"), arrayOf("left","right"),
            arrayOf("100","101","103"),this)
        val assetTypesSpinner=findViewById<Spinner>(R.id.asset_type_spinner)
        assetTypesSpinner.adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOf("All","Wheel Chair","Bed","Xray Scanner","Troley"))
        val assetListView=findViewById<ListView>(R.id.asset_list)
        var arrayList=arrayOf("<Asset Type> <asset id> <near room>","<Asset Type> <asset id> <near room>","<Asset Type> <asset id> <near room>")
        arrayList=arrayList.plus(arrayList)
        arrayList=arrayList.plus(arrayList)
        assetListView.adapter=ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val inflater=getMenuInflater()
        inflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.app_bar_search->{
                searchAsset()
            }
        }
        return true
    }

    fun searchAsset(){
        val searchDialog=Dialog(this)
        searchDialog.setContentView(R.layout.search_asset)
        searchDialog.setTitle("Search asset by ID")
        searchDialog.show()
        val searchBtn=searchDialog.findViewById<ImageButton>(R.id.search_btn)
        searchBtn.setOnClickListener({
            searchDialog.dismiss()
            val progressDialog=Dialog(this)
            progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            progressDialog.window.setBackgroundDrawableResource(android.R.color.transparent)

            progressDialog.setContentView(R.layout.loading)

            val loadingView=progressDialog.findViewById<RotateLoading>(R.id.rotateloading)
            progressDialog.show()
            loadingView.start()
        })
    }
}
