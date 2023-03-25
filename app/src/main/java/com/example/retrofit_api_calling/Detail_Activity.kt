package com.example.retrofit_api_calling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.parseAsHtml
import com.bumptech.glide.Glide
import com.example.retrofit_api_calling.databinding.ActivityDetailBinding
import com.example.retrofit_api_calling.databinding.ActivityMainBinding

class Detail_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bindings= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(bindings.root)
        var pos=intent.getIntExtra("pos",0)
        var model=MainActivity.countryList.get(pos)

        Glide.with(this).load(model.flags?.png).into(bindings.dflags)
        bindings.dname.text=model.name
        bindings.dtopLevelDomain.text=model.topLevelDomain.toString()
        bindings.dcallingCodes.text=model.callingCodes.toString()
        bindings.dcapital.text=model.capital
        bindings.dresion.text=model.region
        bindings.ddemonym.text=model.demonym
        bindings.darea.text=model.area.toString()
        bindings.dtimezone.text=model.timezones.toString()
        bindings.dalpha2Code.text=model.alpha2Code.toString()
        bindings.dalpha3Code.text=model.alpha3Code.toString()
        bindings.daltSpellings.text=model.altSpellings.toString()
        bindings.dsubregion.text=model.subregion.toString()
        bindings.dpopulation.text=model.population.toString()
        bindings.dlatlng.text=model.latlng.toString()
        bindings.dnativeName.text=model.nativeName.toString()
        bindings.dnumericCode.text=model.numericCode.toString()
        bindings.dcurrencies.text=model.currencies.toString().parseAsHtml()
        bindings.dcioc.text=model.cioc.toString()
        bindings.dlanguages.text=model.languages.toString()
        bindings.dborders.text=model.borders.toString()

    }
}