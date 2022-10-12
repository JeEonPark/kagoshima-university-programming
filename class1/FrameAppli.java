/***
 *** Java アプリケーションによるウィンドウの表示
 ***/
import java.awt.*;
import java.awt.event.*;

public class FrameAppli {
	
	//生成
	public FrameAppli(){
		// フレームの生成、サイズの表示、可視化
		Frame frame = new Frame();
		frame.setSize( 640, 480 );
		frame.setVisible( true );
		frame.addWindowListener( new WindowEventHandler() );
	}
	
	// Javaアプリケーション
	public static void main( String [] args ){
		FrameAppli appli = new FrameAppli();
	}
}

// アプリケーション用のウインドウリスナー
class WindowEventHandler extends WindowAdapter {
    public void windowClosing( WindowEvent ev ){
		System.exit(0);
    }
}
