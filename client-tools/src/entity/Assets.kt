package entity

data class Assets(
    val description: String,
    val ledgerSignature: String,
    val lockedAccounts: List<String>,
    val pngUrl: String,
    val social: Social,
    val status: String,
    val svgUrl: String,
    val website: String
)