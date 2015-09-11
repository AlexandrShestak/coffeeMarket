$(document).ready(function() {
   /* $(document).on("change", $('.checkCoffee'), changeCheckBox())*/
    $('.checkCoffee').change(function(){
        var countText = $(this).parent().children("input.countCoffee");
        if ($(this).is(':checked')){
            alert('1')
            countText.show();
        }else{
            alert('2')
            countText.hide()
        }
    })
    $('input:checkbox').change(function(){
        var countText = $(this).parent().children("input.countCoffee");
        if ($(this).is(':checked')){
            alert('1')
            countText.show();
        }else{
            alert('2')
            countText.hide()
        }
    })
})

/*
function changeCheckBox(){
    $(document).ready(function() {
         $('.checkCoffee').change(function(){
             var countText = $(this).parent().children("input.countCoffee");
             if ($(this).is(':checked')){
                 alert('1')
                countText.show();
             }else{
                 alert('2')
                 countText.hide()
             }
         })
    })
}*/
