
// http://stackoverflow.com/questions/1114024/constructors-in-javascript-objects

var MyClass = MyClass ||  (function() { // dont declare again if already loaded
alert('declaring class');
	// private static
    var instanceCount = 0;
    
	// constructor
	var constructor = function( privateFieldValue ) {

		instanceCount++;
		
		var privateField = privateFieldValue;
		
		// public instance method
		this.getPrivateField = function() {

			return privateField;

		}
	};
	
	// public static method
	constructor.getInstanceCount = function() {
		return instanceCount;
	};
	
	// public (shared across instances)
	constructor.prototype = {
        announce: function () {
            return 'My privateField is "' + this.getPrivateField() + '"!\r\n' +
                  'The instanceCount is ' + MyClass.getInstanceCount() + '!';
        }
    };
    
	return constructor;
	
})();

var myClass1 = new MyClass('foo1');
console.log('MyClass.getInstanceCount()=' + MyClass.getInstanceCount());
console.log('myClass1.getPrivateField()=' + myClass1.getPrivateField());
console.log('myClass1.getPrivateField()=' + myClass1.getPrivateField());

var myClass2 = new MyClass('foo2');
console.log('MyClass.getInstanceCount()=' + MyClass.getInstanceCount());
console.log('MyClass.getInstanceCount()=' + MyClass.getInstanceCount());

console.log('myClass2.getPrivateField()=' + myClass2.getPrivateField());

console.log('myClass1.getPrivateField()=' + myClass1.getPrivateField());

console.log('------------------');
console.log('myClass1.announce()=' + myClass1.announce());
console.log('myClass2.announce()=' + myClass2.announce());
//console.log('MyClass.announce()=' + MyClass.announce());

