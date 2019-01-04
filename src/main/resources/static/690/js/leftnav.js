$(function(){
    $('.leftnav .menu_item').each(function(i,item){
        var url = '';
        switch(i){
            case 0: url = '/bigSreen/sys/v1/index';break;
            case 3: url = '/bigSreen/sys/v1/cdwl-sq';break;
            case 4: url = '/bigSreen/sys/v1/cdwl-wg';break;
            case 5: url = '/bigSreen/sys/v1/yhxv';break;
            case 6: url = '/bigSreen/sys/v1/fhxv';break;
            default: url = '#';
        }
        $(item).click(function(){
            location.href = url;
        })
    })
})