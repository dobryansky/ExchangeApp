package com.artem.exchangeapp.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatesDTO(
    @SerialName("base")
    val base: String,
    @SerialName("date")
    val date: String,
   @SerialName("rates")
    val rates: Rates,
    @SerialName("success")
    val success: Boolean
)

@Serializable
data class Rates(
    @SerialName("AED")
    val aED: Double,
    @SerialName("AFN")
    val aFN: Double,
    @SerialName("ALL")
    val aLL: Double,
    @SerialName("AMD")
    val aMD: Double,
    @SerialName("ANG")
    val aNG: Double,
    @SerialName("AOA")
    val aOA: Double,
    @SerialName("ARS")
    val aRS: Double,
    @SerialName("AUD")
    val aUD: Double,
    @SerialName("AWG")
    val aWG: Double,
    @SerialName("AZN")
    val aZN: Double,
    @SerialName("BAM")
    val bAM: Double,
    @SerialName("BBD")
    val bBD: Double,
    @SerialName("BDT")
    val bDT: Double,
    @SerialName("BGN")
    val bGN: Double,
    @SerialName("BHD")
    val bHD: Double,
    @SerialName("BIF")
    val bIF: Double,
    @SerialName("BMD")
    val bMD: Double,
    @SerialName("BND")
    val bND: Double,
    @SerialName("BOB")
    val bOB: Double,
    @SerialName("BRL")
    val bRL: Double,
    @SerialName("BSD")
    val bSD: Double,
    @SerialName("BTC")
    val bTC: Double,
    @SerialName("BTN")
    val bTN: Double,
    @SerialName("BWP")
    val bWP: Double,
    @SerialName("BYN")
    val bYN: Double,
    @SerialName("BZD")
    val bZD: Double,
    @SerialName("CAD")
    val cAD: Double,
    @SerialName("CDF")
    val cDF: Double,
    @SerialName("CHF")
    val cHF: Double,
    @SerialName("CLF")
    val cLF: Double,
    @SerialName("CLP")
    val cLP: Double,
    @SerialName("CNH")
    val cNH: Double,
    @SerialName("CNY")
    val cNY: Double,
    @SerialName("COP")
    val cOP: Double,
    @SerialName("CRC")
    val cRC: Double,
    @SerialName("CUC")
    val cUC: Double,
    @SerialName("CUP")
    val cUP: Double,
    @SerialName("CVE")
    val cVE: Double,
    @SerialName("CZK")
    val cZK: Double,
    @SerialName("DJF")
    val dJF: Double,
    @SerialName("DKK")
    val dKK: Double,
    @SerialName("DOP")
    val dOP: Double,
    @SerialName("DZD")
    val dZD: Double,
    @SerialName("EGP")
    val eGP: Double,
    @SerialName("ERN")
    val eRN: Double,
    @SerialName("ETB")
    val eTB: Double,
    @SerialName("EUR")
    val eUR: Double,
    @SerialName("FJD")
    val fJD: Double,
    @SerialName("FKP")
    val fKP: Double,
    @SerialName("GBP")
    val gBP: Double,
    @SerialName("GYD")
    val gYD: Double,
    @SerialName("HKD")
    val hKD: Double,
    @SerialName("HNL")
    val hNL: Double,
    @SerialName("HRK")
    val hRK: Double,
    @SerialName("HTG")
    val hTG: Double,
    @SerialName("HUF")
    val hUF: Double,
    @SerialName("IDR")
    val iDR: Double,
    @SerialName("ILS")
    val iLS: Double,
    @SerialName("IMP")
    val iMP: Double,
    @SerialName("INR")
    val iNR: Double,
    @SerialName("IQD")
    val iQD: Double,
    @SerialName("IRR")
    val iRR: Double,
    @SerialName("LRD")
    val lRD: Double,
    @SerialName("LSL")
    val lSL: Double,
    @SerialName("LYD")
    val lYD: Double,
    @SerialName("MAD")
    val mAD: Double,
    @SerialName("MDL")
    val mDL: Double,
    @SerialName("MGA")
    val mGA: Double,
    @SerialName("MKD")
    val mKD: Double,
    @SerialName("MMK")
    val mMK: Double,
    @SerialName("MNT")
    val mNT: Double,
    @SerialName("MOP")
    val mOP: Double,
    @SerialName("MRU")
    val mRU: Double,
    @SerialName("UGX")
    val uGX: Double,
    @SerialName("USD")
    val uSD: Double,
    @SerialName("RUB")
    val rUB: Double
)
