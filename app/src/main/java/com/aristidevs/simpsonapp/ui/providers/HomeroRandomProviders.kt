package com.aristidevs.simpsonapp.ui.providers
import com.aristidevs.simpsonapp.R
import com.aristidevs.simpsonapp.ui.model.HomeroModel
import java.util.Random
import javax.inject.Inject


class HomeroRandomProviders @Inject constructor() {
    fun getHomero():HomeroModel? {
        return when(kotlin.random.Random.nextInt(0, 16)){
            0 -> HomeroModel(R.drawable.abbeysimpson, R.string.AbbeySimpson)
            1 -> HomeroModel(R.drawable.capitanmordecaihomero, R.string.CapitanMordecai)
            2 -> HomeroModel(R.drawable.cosmefulanito, R.string.CosmeFulanito)
            3 -> HomeroModel(R.drawable.donbarredorahomero, R.string.DonBarredora)
            4 -> HomeroModel(R.drawable.fatovhomero, R.string.FatovHomero)
            5 -> HomeroModel(R.drawable.hombrepie, R.string.HombrePie)
            6 -> HomeroModel(R.drawable.homeroconductormonoriel, R.string.ConductorMonoriel)
            7 -> HomeroModel(R.drawable.homerofuerte, R.string.HomeroFuerte)
            8 -> HomeroModel(R.drawable.homerogordo, R.string.HomeroGordo)
            9 -> HomeroModel(R.drawable.homeromago, R.string.HomeroMago)
            10 -> HomeroModel(R.drawable.homeromaya, R.string.HomeroMaya)
            11 -> HomeroModel(R.drawable.homeronoir, R.string.HomeroNoir)
            12 -> HomeroModel(R.drawable.homeropreparatoria, R.string.HomeroPreparatoria)
            13 -> HomeroModel(R.drawable.homerosimpson, R.string.HomeroSimpson)
            14 -> HomeroModel(R.drawable.knokahomero, R.string.KnokaHomero)
            15 -> HomeroModel(R.drawable.mrchispahomero, R.string.HomeroMrChispa)
            else -> null
        }
    }

}