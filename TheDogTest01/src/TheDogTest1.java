public class TheDogTest1 {
	public static void main(String[] args) {
		Dog pochi = new Dog();

		pochi.print();
		pochi.roudou();
		pochi.print();
		pochi.roudou();
		pochi.print();
		pochi.shokuji();
		pochi.print();

		pochi.nemui();
		pochi.print();
		pochi.nemukunai();
		pochi.print();
	}
}

	class Dog{
		private DogState myState;

		public Dog() {
			myState = TanoshiiState.getInstance();
		}

		public void roudou() {
			myState.tukareta(this);
		}

		public void shokuji() {
			myState.tabeta(this);
		}

		public void nemui() {
			myState.neru(this);
		}

		public void nemukunai() {
			myState.okiru(this);
		}

		public void changeState(DogState d) {
			myState = d;
		}

		public void print() {
			System.out.print("現在、わたしは「");
			System.out.print( myState.toString() );
			System.out.println("」です。");
		}
	}

	abstract class DogState{
		public abstract void tukareta(Dog yobidashimoto);
		public abstract void tabeta(Dog yobidashimoto);
		public abstract void neru(Dog yobidashimoto);
		public abstract void okiru(Dog yobidashimoto);
	}

	class TanoshiiState extends DogState{
		private static TanoshiiState s = new TanoshiiState();
		private TanoshiiState() {}

		public static DogState getInstance() {
			return s;
		}

		public void tukareta(Dog moto) {
			moto.changeState(FutsuuState.getInstance());
		}

		public void tabeta(Dog moto) {
			// なにもしない
		}
		public String toString() {
			return "楽しい状態";
		}

		public void neru(Dog moto) {
			moto.changeState(NeruState.getInstance());
		}
		public void okiru(Dog moto) {
			// なにもしない
		}
	}

	class FutsuuState extends DogState {
		private static FutsuuState s = new FutsuuState();
		private FutsuuState() {}

		public static DogState getInstance() {
			return s;
		}

		public void tukareta(Dog moto) {
			moto.changeState(IrairaState.getInstance());
		}

		public void tabeta(Dog moto) {
			moto.changeState(TanoshiiState.getInstance());
		}

		public String toString() {
			return "普通状態";
		}

		public void neru(Dog moto) {
			moto.changeState(NeruState.getInstance());
		}
		public void okiru(Dog moto) {
			// なにもしない
		}
	}

	class IrairaState extends DogState {
		private static IrairaState s = new IrairaState();
		private IrairaState() {}

		public static DogState getInstance() {
			return s;
		}

		public void tukareta(Dog moto) {
			// なにもしない
		}

		public void tabeta(Dog moto) {
			moto.changeState(TanoshiiState.getInstance());
		}

		public String toString() {
			return "いらいら状態";
		}

		public void neru(Dog moto) {
			// なにもしない
		}
		public void okiru(Dog moto) {
			// なにもしない
		}


	}

	class NeruState extends DogState{
		private static NeruState s = new NeruState();
		private NeruState() {}

		public static DogState getInstance() {
			return s;
		}

		public void tukareta(Dog moto) {
			// なにもしない
		}

		public void tabeta(Dog moto) {
			// なにもしない
		}
		public String toString() {
			return "寝てる状態";
		}

		public void neru(Dog moto) {
			// なにもしない
		}
		public void okiru(Dog moto) {
			moto.changeState(FutsuuState.getInstance());
		}
	}

