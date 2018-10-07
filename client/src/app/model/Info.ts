export class Info {
  private _about: String;
  private _author: String;
  private _foundationDate: String;
  private _shopName: String;

  constructor (about: String, author: String, foundationDate: String, shopName: String) {
    this._about = about;
    this._author = author;
    this._foundationDate = foundationDate;
    this._shopName = shopName;
  }

  get about(): String {
    return this._about;
  }

  get author(): String {
    return this._author;
  }

  get foundationDate(): String {
    return this._foundationDate;
  }

  get shopName(): String {
    return this._shopName;
  }
}
