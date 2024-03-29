var Brewer = Brewer || {};

Brewer.MaskMoney = (function() {

	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	}

	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney({ decimal: ',', thousands: '.' });
		this.plain.maskMoney({ precision: 0, thousands: '.' });
	}

	return MaskMoney;

}());

Brewer.MaskPhoneNumber = (function() {

	function MaskPhoneNumber() {
		this.inputPhoneNumber = $('.js-phone-number');
	}

	MaskPhoneNumber.prototype.enable = function() {
		var maskBehavior = function (val) {
			return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		};

		var options = {
			onKeyPress: function(val, e, field, options) {
				field.mask(maskBehavior.apply({}, arguments), options);
			}
		};

		this.inputPhoneNumber.mask(maskBehavior, options);
	}

	return MaskPhoneNumber;

}());

Brewer.MaskCep = (function() {

	function MaskCep() {
		this.inputCep = $('.js-cep');
	}

	MaskCep.prototype.enable = function() {
		this.inputCep.mask('00.000-000');
	}

	return MaskCep;

}());

Brewer.MaskDate = (function() {

	function MaskDate() {
		this.inputDate = $('.js-date');
	}

	MaskDate.prototype.enable = function() {
		this.inputDate.mask('00/00/0000');
		this.inputDate.datepicker({
			orientation: 'bottom',
			language: 'pt-BR',
			autoclose: true
		});
	}

	return MaskDate;

}());

Brewer.Security = (function() {

	function Security() {
		this.token = $('input[name=_csrf]').val();
		this.header = $('input[name=_csrf_header]').val();
	}

	Security.prototype.enable = function() {
		$(document).ajaxSend(function(event, jqxhr, settings) {
			jqxhr.setRequestHeader(this.header, this.token);
		}.bind(this));
	}

	return Security;

}());

Brewer.formatarMoeda = function(valor) {
	numeral.locale('pt-br');
	return numeral(valor).format('0,0.00');
}

Brewer.recuperarValor = function(valorFormatado) {
	return numeral(valorFormatado).value();
}

$(function() {
	var maskMoney = new Brewer.MaskMoney();
	var maskPhoneNumber = new Brewer.MaskPhoneNumber();
	var maskCep = new Brewer.MaskCep();
	var maskDate = new Brewer.MaskDate();
	var security = new Brewer.Security();
	maskDate.enable();
	maskMoney.enable();
	maskPhoneNumber.enable();
	maskCep.enable();
	security.enable();
});
