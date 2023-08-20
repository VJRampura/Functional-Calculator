import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

class FunctionalCalculator implements ActionListener,KeyListener
{
		Frame f;	TextField tf,tf1;	Panel p,p1,p2,p3,p4 ;	Color myC ;	char ch,ch1 ;
		Button one,two,three,four,five,six,seven,eight,nine,zer,adding,subtract,divi,mult,eql,clr ; 
		String pattern,g,gA,gB,gC,gD,nPad,str1,temp;   	static String str,updateStr,sL;
		Double d,d1;
		boolean ad,su,mu,de,a1,a2,a3,a4 ;
		
	public FunctionalCalculator(){
	
		f = new Frame("Calculator");
		myC = new Color(108,108,108);
		f.setSize(500,700);
		f.setBackground(myC);
		f.setLayout(new GridLayout(5,0,3,4));
		GridLayout gl = new GridLayout(0,4,3,4);
		p = new Panel();
		p.setLayout(new GridLayout(2,0,0,0));
		tf = new TextField("");
		tf.setEditable(true);
		tf.setSize(p.getSize());
		tf.addKeyListener(this);
		tf.setFont(new Font("Arial",Font.BOLD+Font.PLAIN,40));
		tf1 = new TextField("0");
		tf1.setEditable(false);
		tf1.setSize(p.getSize());
		tf1.setFont(new Font("Arial",Font.BOLD+Font.PLAIN,50));
		p.add(tf);
		p.add(tf1);
		f.add(p);
		
		p1 = new Panel();
		p1.setLayout(gl);
		one = new Button("1");
		one.addActionListener(this);
		p1.add(one);
		two = new Button("2");
		two.addActionListener(this);
		p1.add(two);
		three = new Button("3");
		three.addActionListener(this);
		p1.add(three);
		adding = new Button("+");
		adding.setBackground(new Color(108,151,161));
		adding.addActionListener(this);
		p1.add(adding);
		f.add(p1);
		
		p2 = new Panel();
		p2.setLayout(gl);
		four = new Button("4");
		four.addActionListener(this);
		p2.add(four);
		five = new Button("5");
		five.addActionListener(this);
		p2.add(five);
		six = new Button("6");
		six.addActionListener(this);
		p2.add(six);
		subtract = new Button("-");
		subtract.setBackground(new Color(108,151,161));
		subtract.addActionListener(this);
		p2.add(subtract);
		f.add(p2);
		
		p3 = new Panel();
		p3.setLayout(gl);
		seven = new Button("7");
		seven.addActionListener(this);
		p3.add(seven);
		eight = new Button("8");
		eight.addActionListener(this);
		p3.add(eight);
		nine = new Button("9");
		nine.addActionListener(this);
		p3.add(nine);
		mult = new Button("*");
		mult.setBackground(new Color(108,151,161));
		mult.addActionListener(this);
		p3.add(mult);
		f.add(p3);
		
		p4 = new Panel();
		p4.setLayout(gl);
		clr = new Button("C");
		clr.setBackground(new Color(255,63,0));
		clr.addActionListener(this);
		p4.add(clr);
		zer = new Button("0");
		zer.addActionListener(this);
		p4.add(zer);
		divi = new Button("/");
		divi.setBackground(new Color(108,151,161));
		divi.addActionListener(this);
		p4.add(divi);
		eql = new Button("=");
		eql.setBackground(new Color(255,63,0));
		eql.addActionListener(this);
		p4.add(eql);
		f.add(p4);
		
		
		
		f.setVisible(true);
	}
	
		public void keyPressed(KeyEvent e){
			tf.setEditable(true);
			int k = e.getKeyCode();	
			str = tf.getText();			
			if( str.length() > 0 && k == KeyEvent.VK_BACK_SPACE){
					tf.setEditable(true);
					}else
			if(e.getKeyLocation() != KeyEvent.KEY_LOCATION_NUMPAD){		
					tf.setEditable(false);
					}else
			
			if(e.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD){	
					tf.setEditable(true);
				
			}	
			
			
		}
			
			
			
		public void keyTyped(KeyEvent e){	
				
			ch = e.getKeyChar();
			de = str.endsWith("/");
			mu = str.endsWith("*");
			ad = str.endsWith("+");
			su = str.endsWith("-");
					
					if((su || ad || mu || de)&& ch == '/'){
						e.consume();
						symbolChanged();
						tf.setText(str+"/");
						}else
					if((su || ad || mu || de)&& ch == '*'){
						e.consume();
						symbolChanged();
						tf.setText(str+"*");
						}else	
					if((su || ad || mu || de)&& ch == '+'){
						e.consume();
						symbolChanged();
						tf.setText(str+"+");
						}else	
					if((su || ad || mu || de)&& ch == '-'){
						e.consume();
						symbolChanged();
						tf.setText(str+"-");
						}else	
					if(ch == '.'){
						e.consume();
						}



			
		
		}	
		public void keyReleased(KeyEvent e){				
				int k = e.getKeyCode();	
					if(k == KeyEvent.VK_ENTER && e.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD){
						symbolChanged();
						updateStr = str ;
						devidation();
						multiplication();
						addition();
						subtraction();
						str = updateStr ;
						tf.setText(str.replace("+-","-"));
						tf1.setText("="+updateStr.replace("+-","-"));
						tf.setCaretPosition(updateStr.length());
					}
						
						
						str =  tf.getText();
						updateStr = str ;
							devidation();
							multiplication();
							addition();
							subtraction();
						
						str1 = updateStr ;
						symbolChanged1();
						tf1.setText("="+str1.replace("+-","-"));
						tf.setCaretPosition(str.length());
		}
		
			
			
	
	
	
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == one) {
					tf.setText(tf.getText()+"1");
					}else	
				if(e.getSource() == two) {
					tf.setText(tf.getText()+"2");
					}else	
				if(e.getSource() == three ) {
					tf.setText(tf.getText()+"3");
					}else			
				if(e.getSource() ==  four ){
					tf.setText(tf.getText()+"4");
					}else
				if(e.getSource() ==  five ){	
					tf.setText(tf.getText()+"5");
					}else
				if(e.getSource() == six ){	
					tf.setText(tf.getText()+"6");
					}else
				if(e.getSource() ==  seven ){
					tf.setText(tf.getText()+"7");
					}else
				if(e.getSource() ==  eight ){
					tf.setText(tf.getText()+"8");
					}else
				if(e.getSource() ==  nine ){
					tf.setText(tf.getText()+"9");
					}else
				if(e.getSource() ==  zer ){
					tf.setText(tf.getText()+"0");
					}else
				if(e.getSource() ==  adding ){		
					symbolChanged();
					tf.setText(str+"+");
					}else
				if(e.getSource() ==  subtract ){
					symbolChanged();
					tf.setText(str+"-");
					}else
				if(e.getSource() ==  mult ){
					symbolChanged();
					tf.setText(str+"*");
					}else
				if(e.getSource() ==  divi ){
					symbolChanged();
					tf.setText(str+"/");
					}else
				if(e.getSource() ==  clr ){
					tf.setText("");
					tf1.setText("0");
					}else					
				if(e.getSource() ==  eql ){ 
						symbolChanged();
						updateStr = str ;
						devidation();
						multiplication();
						addition();
						subtraction();
						str = updateStr ;
						tf.setText(str.replace("+-","-"));
						tf1.setText("="+updateStr.replace("+-","-"));
						tf.setCaretPosition(updateStr.length());
					
				}
				
					symbolChanged();
					updateStr = str ;
					devidation();
					multiplication();
					addition();
					subtraction();
					symbolChanged();
					tf1.setText("="+updateStr.replace("+-","-"));
					tf.setCaretPosition(str.length());
				
				
			}
					
			public void symbolChanged1(){ 
					if(str1.endsWith("+"))
						str1 = str1.substring(0,str1.length()-1);
					else
						if(str1.endsWith("/"))
						str1 = str1.substring(0,str1.length()-1);
					else
						if(str1.endsWith("*"))
						str1 = str1.substring(0,str1.length()-1);
					else
						if(str1.endsWith("-"))
						str1 = str1.substring(0,str1.length()-1);
					else
						if(str1.endsWith("."))
						str1 = str1.substring(0,str1.length()-1);
						
			}
			
			public void symbolChanged(){ 
					str = tf.getText(); 
					if(str.endsWith("+"))
						str = str.substring(0,str.length()-1);
					else
						if(str.endsWith("/"))
						str = str.substring(0,str.length()-1);
					else
						if(str.endsWith("*"))
						str = str.substring(0,str.length()-1);
					else
						if(str.endsWith("-"))
						str = str.substring(0,str.length()-1);
					else
						if(str.endsWith("."))
						str = str.substring(0,str.length()-1);
						
			}
			
		public void devidation(){
			for(int i = 1;i < 10 ; i++){

				pattern = "((\\-)?\\d+(\\.\\d+)?)\\/(\\d+(\\.\\d+)?)";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(updateStr);
				if(m.find()){
					g = m.group(0);
					gA = m.group(1);
					gB = m.group(4);
					d = Double.parseDouble(gA);
					d1 = Double.parseDouble(gB);
				Double x = (d/d1);	
				sL = x+"";
				if(sL.indexOf('-') == -1 )
					sL = "+"+sL ;
				updateSr();
				}
			}
		}
			
		public void multiplication(){
			for(int i = 1;i < 10 ; i++){

				pattern = "((\\-)?\\d+(\\.\\d+)?)\\*(\\d+(\\.\\d+)?)";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(updateStr);
				if(m.find()){
					g = m.group(0);
					gA = m.group(1);
					gB = m.group(4);
					d = Double.parseDouble(gA);
					d1 = Double.parseDouble(gB);
				Double x = (d*d1);	
				sL = x+"";
				if(sL.indexOf('-') == -1 )
					sL = "+"+sL ;
				updateSr();	
				}
			}
		}
			
		public void addition(){
			for(int i = 1;i < 10 ; i++){

				pattern = "((\\-)?\\d+(\\.\\d+)?)\\+(\\d+(\\.\\d+)?)";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(updateStr);
				if(m.find()){
					g = m.group(0);
					gA = m.group(1);
					gB = m.group(4);
					d = Double.parseDouble(gA);
					d1 = Double.parseDouble(gB);
					
				Double x = (d+d1);	
				sL = x+"";
				if(sL.indexOf('-') == -1 )
					sL = "+"+sL ;
				updateSr();	
				}
			}
		}
			
		public void subtraction(){
			for(int i = 1;i < 10 ; i++){

				pattern = "((\\-)?\\d+(\\.\\d+)?)\\-(\\d+(\\.\\d+)?)";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(updateStr);
				if(m.find()){
					g = m.group(0);
					gA = m.group(1);
					gB = m.group(4);
						d = Double.parseDouble(gA);
						d1 = Double.parseDouble(gB);
					Double x = (d-d1);	
					sL = x+"";
					if(sL.indexOf('-') == -1 )
					sL = "+"+sL ;
					updateSr();	
				}
			}	
		}	

				public void updateSr(){
					updateStr = updateStr.replace(g,sL);
					updateStr = updateStr.replace("++","+");
					updateStr = updateStr.replace("+-","-");
					updateStr = updateStr.replace("*+","*");
					updateStr = updateStr.replace("/+","/");
				}
	
	public static void main(String args[]) 
	{
		FunctionalCalculator fc = new FunctionalCalculator();
	}
}	