package com.github.bigtoast.jfly.internal.json

import org.codehaus.jackson.JsonFactory
import spock.lang.Specification

class VenueImplSpecs extends Specification {


    def "parsing a valid venue response"(){
        def json = '{"status":"ok","pageNum":1,"totalPages":168,"maxResults":25,"totalResults":4187,"title":"VenuesControllerTitles.List","link":"http://www.ticketfly.com/api/venues/list.json","venues":[{"id":5735,"name":"\\"The Lot\\"","timeZone":"America/Chicago","address1":"401 Colorado St.","address2":"","city":"Austin","stateProvince":"TX","postalCode":"78701","metroCode":"635","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"30.266636","lng":"-97.744399","image":null},{"id":9213,"name":"(do not use))","timeZone":"America/New_York","address1":"do not use","address2":"","city":"sf","stateProvince":"ca","postalCode":"768036","metroCode":"","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"20.907714","lng":"83.122007","image":{"large":{"path":"http://cdn.ticketfly.com/i/00/00/60/97/19-vnlg.jpg","width":300,"height":200},"medium":{"path":"http://cdn.ticketfly.com/i/00/00/60/97/19-vnmd.jpg","width":200,"height":133},"original":{"path":"http://cdn.ticketfly.com/i/00/00/60/97/19-og.jpg","width":555,"height":370},"small":{"path":"http://cdn.ticketfly.com/i/00/00/60/97/19-vnsm.jpg","width":100,"height":67},"square":{"path":"http://cdn.ticketfly.com/i/00/00/60/97/19-sq.jpg","width":100,"height":100},"squareSmall":{"path":"http://cdn.ticketfly.com/i/00/00/60/97/19-sqsm.jpg","width":60,"height":60},"xlarge":{"path":"http://cdn.ticketfly.com/i/00/00/60/97/19-vnxl.jpg","width":500,"height":333}}},{"id":6481,"name":"* Dont use Murray Hill Theater","timeZone":"America/New_York","address1":"932 Edgewood Ave S","address2":"","city":"Jacksonville","stateProvince":"FL","postalCode":"32205","metroCode":"561","country":"","url":"http://www.murrayhilltheatre.com/","blurb":"Live music venue using music to present things of faith in a positive way, reaching out to those w/out understanding of the gospel and encouraging those who do.","urlFacebook":"http://www.facebook.com/MHTRocks?v=wall&ref=ts","urlTwitter":"http://twitter.com/mhtrocks","lat":"30.312766","lng":"-81.718792","image":{"large":{"path":"http://cdn.ticketfly.com/i/00/00/39/15/93-vnlg.png","width":300,"height":200},"medium":{"path":"http://cdn.ticketfly.com/i/00/00/39/15/93-vnmd.png","width":200,"height":133},"original":{"path":"http://cdn.ticketfly.com/i/00/00/39/15/93-og.png","width":256,"height":256},"small":{"path":"http://cdn.ticketfly.com/i/00/00/39/15/93-vnsm.png","width":100,"height":67},"square":{"path":"http://cdn.ticketfly.com/i/00/00/39/15/93-sq.png","width":100,"height":100},"squareSmall":{"path":"http://cdn.ticketfly.com/i/00/00/39/15/93-sqsm.png","width":60,"height":60},"xlarge":{"path":"http://cdn.ticketfly.com/i/00/00/39/15/93-vnxl.png","width":256,"height":256}}},{"id":23,"name":"*Rams Head Live","timeZone":"America/New_York","address1":"20 Market Place","address2":"Power Plant Live!","city":"Baltimore","stateProvince":"MD","postalCode":"21202","metroCode":"512","country":"","url":"http://www.ramsheadlive.com/","blurb":"The concert venue that makes Baltimore ROCK! Large music venue featuring local, national and international musicians and bands.","urlFacebook":"http://www.facebook.com/RamsHeadLive","urlTwitter":"http://twitter.com/ramsheadlive","lat":"39.288871","lng":"-76.607109","image":{"large":{"path":"http://cdn.ticketfly.com/i/00/00/06/91/15-vnlg.jpg","width":300,"height":200},"medium":{"path":"http://cdn.ticketfly.com/i/00/00/06/91/15-vnmd.jpg","width":200,"height":133},"original":{"path":"http://cdn.ticketfly.com/i/00/00/06/91/15-og.jpg","width":720,"height":540},"small":{"path":"http://cdn.ticketfly.com/i/00/00/06/91/15-vnsm.jpg","width":100,"height":67},"square":{"path":"http://cdn.ticketfly.com/i/00/00/06/91/15-sq.jpg","width":100,"height":100},"squareSmall":{"path":"http://cdn.ticketfly.com/i/00/00/06/91/15-sqsm.jpg","width":60,"height":60},"xlarge":{"path":"http://cdn.ticketfly.com/i/00/00/06/91/15-vnxl.jpg","width":500,"height":334}}},{"id":1739,"name":"1015 Folsom","timeZone":"America/Los_Angeles","address1":"1015 Folsom Street","address2":"","city":"San Francisco","stateProvince":"CA","postalCode":"94103","metroCode":"807","country":"","url":"http://www.1015.com/","blurb":"","urlFacebook":"http://www.facebook.com/1015Folsom","urlTwitter":"http://twitter.com/1015sf","lat":"37.778048","lng":"-122.405681","image":null},{"id":8327,"name":"10th & Hennepin","timeZone":"America/Chicago","address1":"10th & Hennepin","address2":"","city":"Minneapolis","stateProvince":"MN","postalCode":"","metroCode":"","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"44.975783","lng":"-93.277966","image":null},{"id":3943,"name":"10th and Hennepin Downtown","timeZone":"America/Chicago","address1":"10th and Hennepin","address2":"","city":"Minneapolis","stateProvince":"MN","postalCode":"","metroCode":"","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"45.005306","lng":"-93.233958","image":null},{"id":4263,"name":"111 Minna","timeZone":"America/Los_Angeles","address1":"111 Minna St","address2":"","city":"San Francisco","stateProvince":"California","postalCode":"94105","metroCode":"807","country":"","url":"http://www.111minnagallery.com/","blurb":"The space at 111 Minna Gallery evokes the dramatic effect of an urban industrial warehouse with 16 feet high walls, floor to ceiling windows facing out on 2nd Street, exposed piping overhead and origi","urlFacebook":"http://www.facebook.com/111minnagallery","urlTwitter":"http://twitter.com/#!/111minnagallery","lat":"37.787448","lng":"-122.399346","image":{"large":{"path":"http://cdn.ticketfly.com/i/00/00/24/08/19-vnlg.jpg","width":300,"height":199},"medium":{"path":"http://cdn.ticketfly.com/i/00/00/24/08/19-vnmd.jpg","width":200,"height":133},"original":{"path":"http://cdn.ticketfly.com/i/00/00/24/08/19-og.jpg","width":575,"height":382},"small":{"path":"http://cdn.ticketfly.com/i/00/00/24/08/19-vnsm.jpg","width":100,"height":66},"square":{"path":"http://cdn.ticketfly.com/i/00/00/24/08/19-sq.jpg","width":100,"height":100},"squareSmall":{"path":"http://cdn.ticketfly.com/i/00/00/24/08/19-sqsm.jpg","width":60,"height":60},"xlarge":{"path":"http://cdn.ticketfly.com/i/00/00/24/08/19-vnxl.jpg","width":500,"height":332}}},{"id":5715,"name":"1135 Decatur","timeZone":"America/Chicago","address1":"1135 Decatur St","address2":"","city":"New Orleans","stateProvince":"LA","postalCode":"70116","metroCode":"622","country":"","url":"","blurb":"Cool multi-level music venue, embracing DJ culture through diverse music genres.","urlFacebook":"https://www.facebook.com/1135Decatur","urlTwitter":"","lat":"29.960572","lng":"-90.059428","image":{"large":{"path":"http://cdn.ticketfly.com/i/00/00/33/56/65-vnlg.jpg","width":300,"height":126},"medium":{"path":"http://cdn.ticketfly.com/i/00/00/33/56/65-vnmd.jpg","width":200,"height":84},"original":{"path":"http://cdn.ticketfly.com/i/00/00/33/56/65-og.jpg","width":960,"height":402},"small":{"path":"http://cdn.ticketfly.com/i/00/00/33/56/65-vnsm.jpg","width":100,"height":42},"square":{"path":"http://cdn.ticketfly.com/i/00/00/33/56/65-sq.jpg","width":100,"height":100},"squareSmall":{"path":"http://cdn.ticketfly.com/i/00/00/33/56/65-sqsm.jpg","width":60,"height":60},"xlarge":{"path":"http://cdn.ticketfly.com/i/00/00/33/56/65-vnxl.jpg","width":500,"height":209}}},{"id":6697,"name":"120 Bay Cafe","timeZone":"America/New_York","address1":"120 Bay Street","address2":"","city":"Staten Island","stateProvince":"NY","postalCode":"10301","metroCode":"501","country":"","url":"http://120baycafe.com","blurb":"This revamped neighborhood bistro is known for the food, live music, surreal artwork, and eclectic crowd. It\'s eccentric vibe is not something you\'d expect from NYC\'s suburban borough.","urlFacebook":"https://facebook.com/120baycafe","urlTwitter":"https://twitter.com/120baycafe","lat":"40.637804","lng":"-74.076038","image":{"large":{"path":"http://cdn.ticketfly.com/i/00/00/40/60/61-vnlg.jpg","width":300,"height":200},"medium":{"path":"http://cdn.ticketfly.com/i/00/00/40/60/61-vnmd.jpg","width":200,"height":133},"original":{"path":"http://cdn.ticketfly.com/i/00/00/40/60/61-og.jpg","width":960,"height":720},"small":{"path":"http://cdn.ticketfly.com/i/00/00/40/60/61-vnsm.jpg","width":100,"height":67},"square":{"path":"http://cdn.ticketfly.com/i/00/00/40/60/61-sq.jpg","width":100,"height":100},"squareSmall":{"path":"http://cdn.ticketfly.com/i/00/00/40/60/61-sqsm.jpg","width":60,"height":60},"xlarge":{"path":"http://cdn.ticketfly.com/i/00/00/40/60/61-vnxl.jpg","width":500,"height":334}}},{"id":2597,"name":"1211 Manchester Street","timeZone":"America/New_York","address1":"1211 Manchester Street","address2":"","city":"Lexington","stateProvince":"KY","postalCode":"40508","metroCode":"541","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"38.058176","lng":"-84.520829","image":null},{"id":4861,"name":"12th Block Pavilion","timeZone":"America/Chicago","address1":"12th Ave Block Party Pavilion","address2":"","city":"Nashville","stateProvince":"TN","postalCode":"37203","metroCode":"659","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"36.152381","lng":"-86.789389","image":null},{"id":3191,"name":"12TH Street Block Party Pavilion","timeZone":"America/New_York","address1":"114 12th Avenue North","address2":"","city":"Nashville","stateProvince":"Tennessee","postalCode":"37203","metroCode":"659","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"0.000000","lng":"0.000000","image":null},{"id":5889,"name":"1300 on Fillmore - SF Chefs","timeZone":"America/Los_Angeles","address1":"1300 Fillmore Street","address2":"","city":"San Francisco","stateProvince":"CA","postalCode":"94115","metroCode":"807","country":"","url":"http://www.1300fillmore.com/","blurb":"","urlFacebook":"","urlTwitter":"","lat":"37.781630","lng":"-122.432249","image":null},{"id":2763,"name":"149 Kent Avenue","timeZone":"America/New_York","address1":"149 Kent Avenue","address2":"between N 5th & N 6th St.","city":"Brooklyn","stateProvince":"NY","postalCode":"11211","metroCode":"501","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"40.717680","lng":"-73.958962","image":null},{"id":7943,"name":"1651 Highland Ave","timeZone":"America/Los_Angeles","address1":"1651 Highland Ave","address2":"","city":"Los Angeles","stateProvince":"CA","postalCode":"90028","metroCode":"803","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"34.100753","lng":"-118.338702","image":null},{"id":4855,"name":"171 Lombardy","timeZone":"America/New_York","address1":"171 Lombardy","address2":"","city":"Brooklyn","stateProvince":"NY","postalCode":"10017","metroCode":"501","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"40.723564","lng":"-73.933711","image":null},{"id":6511,"name":"1772 Market Street","timeZone":"America/Los_Angeles","address1":"1772 Market Street","address2":"","city":"San Francisco","stateProvince":"CA","postalCode":"94103","metroCode":"807","country":"","url":"","blurb":"","urlFacebook":"https://www.facebook.com/1760MarketStreet?fref=ts","urlTwitter":"","lat":"37.787646","lng":"-122.402759","image":null},{"id":3583,"name":"19 Broadway","timeZone":"America/Los_Angeles","address1":"17 Broadway Blvd.","address2":"","city":"Fairfax","stateProvince":"CA","postalCode":"94930","metroCode":"807","country":"","url":"http://www.19broadway.com/","blurb":"19 Broadway is the hottest nightclub in Marin County bringing big name acts for the past 25 years & still going strong!","urlFacebook":"https://www.facebook.com/groups/19Broadway/","urlTwitter":"https://twitter.com/#!/19broadway","lat":"37.986760","lng":"-122.587905","image":{"large":{"path":"http://cdn.ticketfly.com/i/00/00/19/03/43-vnlg.gif","width":300,"height":107},"medium":{"path":"http://cdn.ticketfly.com/i/00/00/19/03/43-vnmd.gif","width":200,"height":71},"original":{"path":"http://cdn.ticketfly.com/i/00/00/19/03/43-og.gif","width":422,"height":150},"small":{"path":"http://cdn.ticketfly.com/i/00/00/19/03/43-vnsm.gif","width":100,"height":36},"square":{"path":"http://cdn.ticketfly.com/i/00/00/19/03/43-sq.gif","width":100,"height":100},"squareSmall":{"path":"http://cdn.ticketfly.com/i/00/00/19/03/43-sqsm.gif","width":60,"height":60},"xlarge":{"path":"http://cdn.ticketfly.com/i/00/00/19/03/43-vnxl.gif","width":422,"height":150}}},{"id":2105,"name":"1st Bank Center","timeZone":"America/Denver","address1":"11450 Broomfield Lane","address2":"","city":"Broomfield","stateProvince":"CO","postalCode":"80021","metroCode":"751","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"39.904696","lng":"-105.085281","image":null},{"id":171,"name":"1st Mariner Arena","timeZone":"America/New_York","address1":"201 West Baltimore Street","address2":"","city":"Baltimore","stateProvince":"MD","postalCode":"21201","metroCode":"512","country":"","url":"http://www.baltimorearena.com/","blurb":"SMG, a Philadelphia based private facility Management Company, assumed leadership of 1st Mariner Arena in 1999. Since then the Arena has hosted some of the biggest names in entertainment.","urlFacebook":"http://www.facebook.com/FirstMarinerArena","urlTwitter":"http://twitter.com/1stmarinerarena","lat":"39.289240","lng":"-76.620466","image":{"large":{"path":"http://cdn.ticketfly.com/i/00/00/06/98/41-vnlg.jpg","width":300,"height":200},"medium":{"path":"http://cdn.ticketfly.com/i/00/00/06/98/41-vnmd.jpg","width":200,"height":133},"original":{"path":"http://cdn.ticketfly.com/i/00/00/06/98/41-og.jpg","width":201,"height":201},"small":{"path":"http://cdn.ticketfly.com/i/00/00/06/98/41-vnsm.jpg","width":100,"height":67},"square":{"path":"http://cdn.ticketfly.com/i/00/00/06/98/41-sq.jpg","width":100,"height":100},"squareSmall":{"path":"http://cdn.ticketfly.com/i/00/00/06/98/41-sqsm.jpg","width":60,"height":60},"xlarge":{"path":"http://cdn.ticketfly.com/i/00/00/06/98/41-vnxl.jpg","width":201,"height":201}}},{"id":6833,"name":"2 Bit Saloon","timeZone":"America/Los_Angeles","address1":"4818 17th Avenue Northwest","address2":"","city":"Seattle","stateProvince":"WA","postalCode":"98107","metroCode":"819","country":"","url":"http://www.the2bitsaloon.com/","blurb":"Mission\\r\\nTo have the best time in the world, everytime!","urlFacebook":"https://www.facebook.com/the2bitsaloon","urlTwitter":"","lat":"47.664197","lng":"-122.378664","image":{"large":{"path":"http://cdn.ticketfly.com/i/00/00/41/91/17-vnlg.jpg","width":300,"height":197},"medium":{"path":"http://cdn.ticketfly.com/i/00/00/41/91/17-vnmd.jpg","width":200,"height":131},"original":{"path":"http://cdn.ticketfly.com/i/00/00/41/91/17-og.jpg","width":960,"height":630},"small":{"path":"http://cdn.ticketfly.com/i/00/00/41/91/17-vnsm.jpg","width":100,"height":66},"square":{"path":"http://cdn.ticketfly.com/i/00/00/41/91/17-sq.jpg","width":100,"height":100},"squareSmall":{"path":"http://cdn.ticketfly.com/i/00/00/41/91/17-sqsm.jpg","width":60,"height":60},"xlarge":{"path":"http://cdn.ticketfly.com/i/00/00/41/91/17-vnxl.jpg","width":500,"height":328}}},{"id":1703,"name":"2020 Nightclub","timeZone":"America/New_York","address1":"2020 West Pensacola Street #120a","address2":"","city":"Tallahassee","stateProvince":"Florida","postalCode":"32304","metroCode":"530","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"30.442218","lng":"-84.320572","image":null},{"id":2585,"name":"20th Century Theatre","timeZone":"America/New_York","address1":"3021 Madison Road","address2":"","city":"Cincinnati","stateProvince":"OH","postalCode":"45209","metroCode":"515","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"39.151119","lng":"-84.432897","image":null},{"id":7607,"name":"219 West","timeZone":"America/Chicago","address1":"612 W. 6th St","address2":"","city":"Austin","stateProvince":"TX","postalCode":"78701","metroCode":"635","country":"","url":"","blurb":"","urlFacebook":"","urlTwitter":"","lat":"30.270109","lng":"-97.748995","image":null}],"source":"freetext"}'
        def parser = (new JsonFactory()).createJsonParser(json);
        def response = new PaginatedResponseImpl(parser,"venues",VenueImpl.class)

        expect :
            response.status == "ok"
            response.pageNum == 1
            response.totalPages == 168
            response.maxResults == 25
            response.totalResults == 4187
            response.size() == 25
    }

    def "parsing a single venue"(){
        def json = """{
            "id":6481,
            "name":"* Dont use Murray Hill Theater",
            "timeZone":"America/New_York",
            "address1":"932 Edgewood Ave S",
            "address2":"",
            "city":"Jacksonville",
            "stateProvince":"FL",
            "postalCode":"32205",
            "metroCode":"561",
            "country":"",
            "url":"http://www.murrayhilltheatre.com/",
            "blurb":"Live music venue using music to present things of faith in a positive way, reaching out to those w/out understanding of the gospel and encouraging those who do.",
            "urlFacebook":"http://www.facebook.com/MHTRocks?v=wall&ref=ts",
            "urlTwitter":"http://twitter.com/mhtrocks",
            "lat":"30.312766",
            "lng":"-81.718792",
            "image":{
                "large":{
                    "path":"http://cdn.ticketfly.com/i/00/00/39/15/93-vnlg.png",
                    "width":300,
                    "height":200
                },
                "medium":{
                    "path":"http://cdn.ticketfly.com/i/00/00/39/15/93-vnmd.png",
                    "width":200,
                    "height":133
                },
                "original":{
                    "path":"http://cdn.ticketfly.com/i/00/00/39/15/93-og.png",
                    "width":256,
                    "height":256
                },
                "small":{
                    "path":"http://cdn.ticketfly.com/i/00/00/39/15/93-vnsm.png",
                    "width":100,
                    "height":67
                },
                "square":{
                    "path":"http://cdn.ticketfly.com/i/00/00/39/15/93-sq.png",
                    "width":100,
                    "height":100
                },
                "squareSmall":{
                    "path":"http://cdn.ticketfly.com/i/00/00/39/15/93-sqsm.png",
                    "width":60,
                    "height":60
                },
                "xlarge":{
                    "path":"http://cdn.ticketfly.com/i/00/00/39/15/93-vnxl.png",
                    "width":256,
                    "height":256
                }
            }
        }"""

        def parser = (new JsonFactory()).createJsonParser(json)
        parser.nextToken()
        def venue = new VenueImpl( parser )
        expect :
            venue.id == 6481
            venue.latitude == 30.312766d
            venue.longitude == -81.718792d
            venue.image.large.width == 300
            venue.image.medium.width == 200
            venue.image.original.width == 256
            venue.image.small.width == 100
            venue.image.square.width == 100
            venue.image.squareSmall.width == 60
            venue.image.getXLarge().width == 256
            venue.websiteUrl.toString() == 'http://www.murrayhilltheatre.com/'


    }
}
