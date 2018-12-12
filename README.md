## Sell Me Good

### Demo is available!
[Demo(on AWS)](https://ec2-18-222-189-102.us-east-2.compute.amazonaws.com)

This is a Java Web application based on Web Services (SOAP and REST).

The application represents a simple e-commerce online store for selling and buying goods.

### Dockerizing
#### Client
Node.js client is dockerized in it's own container. All configs are in Dockerfile.
Assuming you are in ```client``` folder.
To build image run: ```npm run docker-build```
To run image run: ```npm run docker-run```
If you want to check working container run: ```npm run check-docker-client```, then you'll see something like this:
![docker client](https://github.com/vladislav-klochkov/sell-me-good/blob/master/Docker-client.png) 

### How to start project
To run server side you need:
- Java 1.8 or later;
- GlassFish 5.0 or later;

To run client side you need(currently not working):
- Node 10.8 or later;

Then run the following:
```
cd client
npm i
npm start
```
And open browser on the page: ```http://localhost:3000```

### Architecture
#### Server
Server app is build up with Java EE service GlassFish.

#### SOAP Part
Currently now there are 2 SOAP services: ```com.vklochkov.soap.ProductCatalog``` and ```com.vklochkov.soap.ShopInfo```

Example of the WSDL file for ```com.vklochkov.soap.ShopInfo``` service:
```$xslt
<definitions xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsp="http://www.w3.org/ns/ws-policy" xmlns:wsp1_2="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://sellmegood.com" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns="http://schemas.xmlsoap.org/wsdl/" targetNamespace="http://sellmegood.com" name="ShopInfoService">
    <types>
        <xsd:schema>
            <xsd:import namespace="http://sellmegood.com" schemaLocation="http://vladislav-laptop:8080/sell_me_good_war_exploded/ShopInfoService?xsd=1"/>
        </xsd:schema>
    </types>

    <message name="getShopInfo"/>
    <message name="getShopInfoResponse">
        <part name="shopInfo" type="tns:info"/>
    </message>

    <portType name="com.vklochkov.soap.ShopInfoImpl">
        <operation name="getShopInfo">
            <input wsam:Action="get_shop_info" message="tns:getShopInfo"/>
            <output wsam:Action="http://sellmegood.com/com.vklochkov.soap.ShopInfoImpl/getShopInfoResponse" message="tns:getShopInfoResponse"/>
        </operation>
    </portType>

    <binding name="ShopInfoPortBinding" type="tns:com.vklochkov.soap.ShopInfoImpl">
        <soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="rpc"/>
        <operation name="getShopInfo">
            <soap:operation soapAction="get_shop_info"/>
            <input>
                <soap:body use="literal" namespace="http://sellmegood.com"/>
            </input>
            <output>
                <soap:body use="literal" namespace="http://sellmegood.com"/>
            </output>
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

For ```com.vklochkov.soap.ProductCatalog``` there are:

- ```getProductCategories()```
- ```getProductsByCategory(String category)```
- ```addProduct(String category, String product)```

For ```Shop Info.ts``` there is:
- ```getShopInfo()```

Example of SOAP request for ```com.vklochkov.soap.ProductCatalog.getProductsByCategory("films")```:
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

#### REST Part
REST part is made on ```Jersey``` RESTful Web Services(more about [Jersey](https://jersey.github.io/index.html))

##### Product Service:
Consists of one method:
```java
@GET
@Produces(MediaType.APPLICATION_JSON)
public ArrayList<ProductBean> getProducts () {}
```

##### Info Service
Consists of two methods:
```java
@GET
@Produces(MediaType.APPLICATION_JSON)
public InfoBean getInfo () {}
```
and
```java
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public InfoBean saveInfo(Info info) {}
```
The endpoint for these methods: ```/sellmegood/api/info```

#### Client
Client is build on NodeJS/Angular 6 stack.
