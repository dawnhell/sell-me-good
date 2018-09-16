## Sell Me Good

This is a Java Web application based on Web Services (SOAP and REST).

The application represents a simple e-commerce online store for selling and buying goods.

### How to start project
To run server side you need:
- Java 1.8 or later;
- GlassFish 5.0 or later;

To run client side you need:
- Node 10.8 or later;

Then run the following:
```
cd client
npm i
npm start
```

### Architecture
#### Server
Server app is build up with Java EE service GlassFish.

Currently now there are 2 SOAP services: ```ProductCatalog``` and ```ShopInfo```

Example of the WSDL file for ```ShopInfo``` service:
```$xslt
<definitions xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsp="http://www.w3.org/ns/ws-policy" xmlns:wsp1_2="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://sellmegood.com" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns="http://schemas.xmlsoap.org/wsdl/" targetNamespace="http://sellmegood.com" name="ShopInfoService">
    <types>
        <xsd:schema>
            <xsd:import namespace="http://sellmegood.com" schemaLocation="http://vladislav-laptop:8080/sell_me_good_war_exploded/ShopInfoService?xsd=1"/>
        </xsd:schema>
    </types>
    
    <message name="getShopInfo">
        <part name="parameters" element="tns:getShopInfo"/>
    </message>

    <message name="getShopInfoResponse">
        <part name="parameters" element="tns:getShopInfoResponse"/>
    </message>

    <message name="InvalidInputException">
        <part name="fault" element="tns:InvalidInputException"/>
    </message>

    <portType name="ShopInfoImpl">
        <operation name="getShopInfo">
            <input wsam:Action="get_shop_info" message="tns:getShopInfo"/>
            <output wsam:Action="http://sellmegood.com/ShopInfoImpl/getShopInfoResponse" message="tns:getShopInfoResponse"/>
            <fault message="tns:InvalidInputException" name="InvalidInputException" wsam:Action="http://sellmegood.com/ShopInfoImpl/getShopInfo/Fault/InvalidInputException"/>
        </operation>
    </portType>

    <binding name="ShopInfoPortBinding" type="tns:ShopInfoImpl">
        <soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="document"/>
        <operation name="getShopInfo">
            <soap:operation soapAction="get_shop_info"/>
            <input>
                <soap:body use="literal"/>
            </input>
            <output>
                <soap:body use="literal"/>
            </output>
            <fault name="InvalidInputException">
                <soap:fault name="InvalidInputException" use="literal"/>
            </fault>
        </operation>
    </binding>

    <service name="ShopInfoService">
        <port name="ShopInfoPort" binding="tns:ShopInfoPortBinding">
            <soap:address location="http://vladislav-laptop:8080/sell_me_good_war_exploded/ShopInfoService"/>
        </port>
    </service>
</definitions>
```

There also available several SOAP requests for this services.

For ```ProductCatalog``` there are:

- ```getProductCategories()```
- ```getProductsByCategory(String category)```
- ```addProduct(String category, String product)```

For ```Shop Info``` there is:
- ```getShopInfo(String property)```

Example of SOAP request for ```ProductCatalog.getProductsByCategory("films")```:
##### SOAP Request
```$xslt
<?xml version="1.0" encoding="UTF-8"?><S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <S:Body xmlns:ns2="http://sellmegood.com">
        <ns2:getProductsByCategory>
            <arg0>films</arg0>
        </ns2:getProductsByCategory>
    </S:Body>
</S:Envelope>
```
##### SOAP Response
```$xslt
<?xml version="1.0" encoding="UTF-8"?><S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <S:Body xmlns:ns2="http://sellmegood.com">
        <ns2:getProductsByCategoryResponse>
            <Product>
                <name>Film 1</name>
                <price>11.0</price>
                <sku>film1 sku</sku>
            </Product>
            <Product>
                <name>Film 2</name>
                <price>12.0</price>
                <sku>film2 sku</sku>
            </Product>
            <Product>
                <name>Film 3</name>
                <price>13.0</price>
                <sku>film3 sku</sku>
            </Product>
        </ns2:getProductsByCategoryResponse>
    </S:Body>
</S:Envelope>
```

#### Client
Client is build on NodeJS/Angular 6 stack.