$(function () {
    $('#change').click(function () {
        let val1 = $('#val1').val();
        let val2 = $('#val2').val();
        let amount2 = $('#amount2').val();
        if (!val1) {
            $('#val1').css("border-color", "red");
        } else {
            $('#val1').css("border", "");
        }

        if (!val2) {
            $('#val2').css("border-color", "red");
        } else {
            $('#val2').css("border", "");
        }

        if (!amount2) {
            $('#amount2').css("border-color", "red");
        } else {
            $('#amount2').css("border", "");
        }

        if (!val1 || !val2) {
            alert('Необходимо указать значения валют!')
            return;
        }

        if (!amount2) {
            alert('Укажите сумму!')
            return;
        }

        if (amount2 <= 0) {
            alert('Введите положительное значение!')
            return;
        }

        $.ajax({
            url: '/change/countCourse?val1=' + val1 + '&val2=' + val2 + '&amount2=' + amount2,
            type: 'POST',
            success: function (result) {
                $('#result').text('По курсу ЦБ, установленному на ' + result.dateCourse + ',  '
                    + amount2 + ' ' + result.valute2 + ' Вы можете купить за: ' + result.value + ' ' + result.valute1);
            }
        });
    });
});