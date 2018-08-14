var MyObject = function () {
  var renderCustomField = function (self, jsonschema) {
    console.log(jsonschema.fields);

    function getFun(val) {
      return function () {
        this.$root.$emit("bv::show::modal", val);
      };
    }

    if (jsonschema.fields) {
      for (var i = 0; i < self.jsonschema.fields.length; i++) {
        var currentField = jsonschema.fields[i];

        if (currentField.idprovider) {
          console.log("Provider: ", currentField.idprovider);

          var buttton = [{
            classes: "btn-location",

            label: currentField.idprovider,

            onclick: getFun(currentField.idprovider)
          }];

          currentField.buttons = buttton;
        }
      }
    }
  };

  return {
    renderCustomField: renderCustomField
  }
}();

export default MyObject;