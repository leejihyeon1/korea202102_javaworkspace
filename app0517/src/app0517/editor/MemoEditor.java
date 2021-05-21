package app0517.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//메모장 기능중 스트림으로 처리할 수 있는 부분을 코드로 구현해본다!
public class MemoEditor extends JFrame{
	JMenuBar bar;
	JMenu m_file;
	JMenuItem item_new;
	JMenuItem item_open;
	JMenuItem item_save;
	JMenuItem item_saveas;
	JMenuItem item_exit;
	JTextArea area;
	JScrollPane scroll;
	JFileChooser chooser;//파일 탐색기
	
	public MemoEditor() {
		bar=new JMenuBar();
		m_file=new JMenu("파일");
		item_new=new JMenuItem("새파일");
		item_open=new JMenuItem("열기");
		item_save=new JMenuItem("저장");
		item_saveas=new JMenuItem("새이름으로 저장");
		item_exit=new JMenuItem("끝내기");
		area=new JTextArea();
		scroll=new JScrollPane(area);
		chooser=new JFileChooser("C:\\korea202102_javaworkspace\\app0514\\src");
		
		m_file.add(item_new);
		m_file.add(item_open);
		m_file.add(item_save);
		m_file.add(item_saveas);
		m_file.add(item_exit);
		bar.add(m_file);//메뉴바에 파일메뉴 부착
		
		//일회성일때 사용하는 "내부익명클래스"
		//내부익명클래스의 사용 목적? 원래 클래스란 코드의 재사용성을 위한 거푸집이 목적이다
		//하지만, 클래스 중에는 재사용성이 별로 없는 일회성의 클래스도 있다.. 이런 경우 굳이 개발자가 .java파일을
		//물리적으로 정의해가면서까지 개발할 필요가 있는가? 따라서 sun에서는 클래스 안에 이름없는 클래스를 넣을 수 있도록
		//내부익명클래스를 지원해주며, 주로 이벤트 구현시 압도적으로 많이 사용된다
		//또한 내부익명 클래스를 사용하면, 객체간 주소를 전달해야하는 불편함도 해소할 수 있다.. 즉 내부익명클래스는 
		//외부클래스의 멤버들을 자기것처럼 접근할 수 있다
		item_open.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//파일 열기 아이템을 누르면, 파일 열어서 출력
				area.setText("");
				openFile();	
			}
		});
		item_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 새파일은 area를 깨끗이 비워놓는 것
				area.setText("");//공백문자로 대체
				
			}
		});
		//새이름으로 저장
		item_saveas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveAsFile();
			}
		});
		//저장
		item_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
				
			}
		});
		//끝내기
		item_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
				
			}
		});
		setJMenuBar(bar);//프레임에 메뉴 부착!
		add(scroll);
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//무언가 창을 닫을때, 자원을 반납하려면
		//이 메서드 호출대신 windowListener를 구현하자!
	}

	//파일 열어서, 편집기창에 출력하기(불러오기)
	public void openFile() {
		FileReader reader=null;//close()하기위해 밖으로 뺌
		BufferedReader buffr=null;//문자스트림을 대상으로 버퍼를 지원하는 시스템
		
		int res=chooser.showOpenDialog(this);
		if(res==chooser.APPROVE_OPTION) {
			//선택한 파일에 대한 입력스트림 생성하여, 내용을 읽어와서 area에 출력!
			File file=chooser.getSelectedFile();//선택한 파일 반환 받음
			try {
				reader=new FileReader(file);//문자(한글,영문)를 읽을 수 있는 스트림 생성
				buffr=new BufferedReader(reader);//버퍼처리된 스트림으로 업그레이드 
				String data=null;
				while(true) {
					data=buffr.readLine();
					if(data==null)break;
					area.append(data+"\n");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(buffr!=null) {
					try {
						buffr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(reader!=null) {
						try {
							reader.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			}
		}
	}
	public void saveAsFile() {
		FileWriter writer=null;
		BufferedWriter buffw=null;
		// 탐색기띄우기
		//선택한 파일경로 얻기
		//빈파일을 파일출력스트림으로 생성
		//생성된 파일출력스트림을 통해 area의 내용을 파일에 넣는다(출력)
		int res=chooser.showSaveDialog(this);
		if(res==chooser.APPROVE_OPTION) {
			File file=chooser.getSelectedFile();
			String path=file.getAbsolutePath();
			try {
				String txt=area.getText();
				writer=new FileWriter(path);
				buffw=new BufferedWriter(writer);//scroll처럼 업그레이드 느낌!
				buffw.write(txt);
				System.out.println("새이름으로 저장 완료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(buffw!=null) {
					try {
						buffw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(writer!=null) {
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	//기존파일에 저장
	public void saveFile() {
		FileWriter writer=null;
		BufferedWriter buffw=null;
		File file=chooser.getSelectedFile();
		if(file==null) {
			int res=chooser.showSaveDialog(this);
			if(res==JFileChooser.APPROVE_OPTION) {
				String txt=area.getText();
				try {
					writer=new FileWriter(file);
					buffw=new BufferedWriter(writer);
					buffw.write(txt);
					System.out.println("기존 파일에 저장 완료");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(buffw!=null) {
						try {
							buffw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(writer!=null) {
						try {
							writer.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}else {
			String txt=area.getText();
			try {
				writer=new FileWriter(file);
				buffw=new BufferedWriter(writer);
				buffw.write(txt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(buffw!=null) {
					try {
						buffw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(writer!=null) {
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
		
	public static void main(String[] args) {
		new MemoEditor();
	}
}
