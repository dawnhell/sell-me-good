export class Product {
  private _id: number;
  private _live: number;
  private _categoryId: number;
  private _unlimited: number;
  private _price: number;
  private _weight: number;
  private _stock: number;
  private _sku: String;
  private _name: String;
  private _cartDesc: String;
  private _shortDesc: String;
  private _longDesc: String;
  private _thumb: String;
  private _image: String;
  private _updateDate: String;
  private _location: String;

  constructor(id: number, live: number, categoryId: number, unlimited: number, price: number, weight: number, stock: number, sku: String, name: String, cartDesc: String, shortDesc: String, longDesc: String, thumb: String, image: String, updateDate: String, location: String) {
    this._id = id;
    this._live = live;
    this._categoryId = categoryId;
    this._unlimited = unlimited;
    this._price = price;
    this._weight = weight;
    this._stock = stock;
    this._sku = sku;
    this._name = name;
    this._cartDesc = cartDesc;
    this._shortDesc = shortDesc;
    this._longDesc = longDesc;
    this._thumb = thumb;
    this._image = image;
    this._updateDate = updateDate;
    this._location = location;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get live(): number {
    return this._live;
  }

  set live(value: number) {
    this._live = value;
  }

  get categoryId(): number {
    return this._categoryId;
  }

  set categoryId(value: number) {
    this._categoryId = value;
  }

  get unlimited(): number {
    return this._unlimited;
  }

  set unlimited(value: number) {
    this._unlimited = value;
  }

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }

  get weight(): number {
    return this._weight;
  }

  set weight(value: number) {
    this._weight = value;
  }

  get stock(): number {
    return this._stock;
  }

  set stock(value: number) {
    this._stock = value;
  }

  get sku(): String {
    return this._sku;
  }

  set sku(value: String) {
    this._sku = value;
  }

  get name(): String {
    return this._name;
  }

  set name(value: String) {
    this._name = value;
  }

  get cartDesc(): String {
    return this._cartDesc;
  }

  set cartDesc(value: String) {
    this._cartDesc = value;
  }

  get shortDesc(): String {
    return this._shortDesc;
  }

  set shortDesc(value: String) {
    this._shortDesc = value;
  }

  get longDesc(): String {
    return this._longDesc;
  }

  set longDesc(value: String) {
    this._longDesc = value;
  }

  get thumb(): String {
    return this._thumb;
  }

  set thumb(value: String) {
    this._thumb = value;
  }

  get image(): String {
    return this._image;
  }

  set image(value: String) {
    this._image = value;
  }

  get updateDate(): String {
    return this._updateDate;
  }

  set updateDate(value: String) {
    this._updateDate = value;
  }

  get location(): String {
    return this._location;
  }

  set location(value: String) {
    this._location = value;
  }
}
