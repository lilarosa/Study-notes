package interface_bespiel;

public interface Document {
	// Keine Attribute!
	// nur abstrakte Methoden
	public void ausgeben();
	
}

// 接口 存在的唯一意义就是方法被实现
// 接口中只提供方法名， 不定义方法实现 ，方法实现必须在继承类中被定义和实现