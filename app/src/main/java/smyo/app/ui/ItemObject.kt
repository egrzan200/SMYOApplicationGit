package smyo.app.ui

class ItemObject {
    var id : Int = 0
    var itemName : String = ""
    var itemPath : String = ""
    var itemTags : String = ""
    var itemPrice : Int = 0

    constructor(itemName: String, itemPath : String, itemTags : String, itemPrice : Int){
        this.itemName = itemName
        this.itemPath = itemPath
        this.itemTags = itemTags
        this.itemPrice = itemPrice
    }
}