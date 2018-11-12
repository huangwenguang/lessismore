$.ajax({
    type: "GET",
    url: config.server + "/info/infoApi.do",
    success: function (result) {
        console.log(result);
        var data = result.data;
        $('#name').html(data.name);
        $('#telephone').html(data.telephone);
        $('#phone').html(data.phone);
        $('#qq').html(data.qq);
        $('#subway').html(data.subway);
        $('#address').html('<a target="_blank" href="http://ditu.amap.com/dir?from[name]=我的位置&from[id]=dirmyloc&from[adcode]=440100&from[poitype]=&from[lnglat]=113.2967,23.34989&from[modxy]=113.2967,23.34989&to[name]=广东省广州市少即多九洲创意园&to[lnglat]=113.290002,23.341593&to[id]=B0FFG82TIH&to[poitype]=120100&to[adcode]=440100&to[modxy]=113.289894,23.341881&type=car&policy=1">'+ data.address +'</a>');
    }
})