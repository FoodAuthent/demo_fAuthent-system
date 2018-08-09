var MyObject = function() {
var getProducts = function(self){
   fetch("https://jsonplaceholder.typicode.com/posts")
      .then((j) => {
        return j.json();
      })
      .then ((r) => {
        self.items = r;
      })
}

        return {
            getProducts: getProducts
        }
    }();

export default MyObject;
