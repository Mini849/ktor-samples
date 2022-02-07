package entity.database

import entity.Assets
import org.jetbrains.exposed.sql.Table

class Tables {

    object ElrondResponse : Table("user") {
        val id = integer("id")
        var accounts = varchar("accounts", length = 100)
        var assets = varchar("assets", length = 100)
        var burnt = varchar("burnt", length = 100)
        var canBurn = varchar("canBurn", length = 100)
        var canChangeOwner = varchar("canChangeOwner", length = 100)
        var canFreeze = varchar("canFreeze", length = 100)
        var canMint = varchar("canMint", length = 100)
        var canPause = varchar("canPause", length = 100)
        var canUpgrade = varchar("canUpgrade", length = 100)
        var canWipe = varchar("canWipe", length = 100)
        var decimals = varchar("decimals", length = 100)
        var identifier = varchar("identifier", length = 100)
        var isPaused = varchar("isPaused", length = 100)
        var minted = varchar("minted", length = 100)
        var name = varchar("name", length = 100)
        var owner = varchar("owner", length = 100)
        var ticker = varchar("ticker", length = 100)
        var transactions = varchar("transactions", length = 100)
    }
    data class ElrondResponses( var accounts: Int,
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
                      var transactions: Int)






















}