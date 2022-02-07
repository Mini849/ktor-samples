package entity

data class ElrondResponse(
    var accounts: Int,
    var assets: Assets,
    var burnt: String,
    var canBurn: Boolean,
    var canChangeOwner: Boolean,
    var canFreeze: Boolean,
    var canMint: Boolean,
    var canPause: Boolean,
    var canUpgrade: Boolean,
    var canWipe: Boolean,
    var decimals: Int,
    var identifier: String,
    var isPaused: Boolean,
    var minted: String,
    var name: String,
    var owner: String,
    var ticker: String,
    var transactions: Int
)