/*
 * Author: Francisco Cuevas
 * Date: 25 Sep 2023
 * Description:
 *      This file is used to manage the "Marca" resource (list.html, add.html).
 *      Script para gestionar las operaciones relacionadas con las marcas.
 *      Aquí se manejan las validaciones, errores, envío de datos de formularios
 *      relacionadas con la gestión de marcas, como la creación, actualización y
 *      eliminación de marcas.
 **/
$(function () {
	/**
	 * *************************************************************************
	 * Listado de Marcas.
	 * *************************************************************************
	 */
	$("#dataTableMarcas").DataTable({
		"responsive": true,
		"lengthChange": false,
		"autoWidth": false,
		"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
		}).buttons().container().appendTo('.col-md-6:eq(0)');
	/**
	* *************************************************************************
	* End Listado de Marcas.
	* *************************************************************************
	*/



	/**
	 * *************************************************************************
	 * Formulario para crear nueva Marca.
	 * *************************************************************************
	 */
	 jQuery.validator.addMethod("noSpace", function(value, element) {
       return value.indexOf(" ") < 0 && value != "";
   }, "Completa este campo");

	$('#marcasAddForm').validate({
		rules: {
			nombre: {
				required: true,
				minlength: 2,
				maxlength: 255,
				noSpace: true
			},
		},
		messages: {
			nombre: {
				required: "Completa este campo",
				minlength: "Aumenta la longitud de este texto a 2 caracteres o más (actualmente, el texto tiene 1 carácter).",
				maxlength: "El texto debe tener hasta 255 caracteres.",
				required: "Completa este campo",
			}
		},
		errorElement: 'span',
		errorPlacement: function (error, element) {
			error.addClass('invalid-feedback');
			element.closest('.form-group').append(error);
		},
		highlight: function (element, errorClass, validClass) {
			$(element).addClass('is-invalid');
		},
		unhighlight: function (element, errorClass, validClass) {
			$(element).removeClass('is-invalid');
		}
	});
	/**
	 * *************************************************************************
	 * End Formulario para crear nueva Marca.
	 * *************************************************************************
	 */

});
