/***
 *** Java �A�v���P�[�V�����ɂ��E�B���h�E�̕\��
 ***/
import java.awt.*;
import java.awt.event.*;

public class FrameAppli {
	
	//����
	public FrameAppli(){
		// �t���[���̐����A�T�C�Y�̕\���A����
		Frame frame = new Frame();
		frame.setSize( 640, 480 );
		frame.setVisible( true );
		frame.addWindowListener( new WindowEventHandler() );
	}
	
	// Java�A�v���P�[�V����
	public static void main( String [] args ){
		FrameAppli appli = new FrameAppli();
	}
}

// �A�v���P�[�V�����p�̃E�C���h�E���X�i�[
class WindowEventHandler extends WindowAdapter {
    public void windowClosing( WindowEvent ev ){
		System.exit(0);
    }
}
