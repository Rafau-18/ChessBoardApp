package rafal.example.szachownica

data class DatabaseClockSetup (
    val clock_tempo: Int,
    val increment_clock_time: Int,
    val WhiteName: String,
    val BlackName: String,
    val start_flag: Boolean){
}