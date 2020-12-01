package Examine_Pro;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Paper29Java003 {
    private Frame f;
    private MenuBar mb;
    private Menu mFile;
    private MenuItem mSave,mExit;
    private FileDialog fd;
    private String fileName;
    private char ch;
    private String s="";
    private TextArea ta;
    private MenuListener menuListener;
    private FileOutputStream fos;
    private OutputStreamWriter osw;

    public Paper29Java003()
    {
        f=new Frame("简单文本编辑器");
        mb=new MenuBar();
        //*********Found********
        mFile=new Menu("文件"); // 文件
        mSave=new MenuItem("保存");
        mExit=new MenuItem("退出");

        f.setMenuBar(mb);
        mb.add(mFile);
        mFile.add(mSave);
        mFile.addSeparator();
        mFile.add(mExit);

        ta=new TextArea("",10,10);
        f.add("Center",ta);
        ta.setForeground(Color.black);
        ta.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent ev)
            {
                s+=ev.getKeyChar();
            }
        });

        f.setSize(800,600);
        f.setVisible(true);

        menuListener=new MenuListener();
        //*********Found********
        mExit.addActionListener(menuListener);
        //*********Found********
        mSave.addActionListener(menuListener);

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(1);    //关闭窗口
            }
        });
    }

    public static void main(String args[])
    {
        Paper29Java003 te=new Paper29Java003();
    }

    class MenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ev)
        {
            MenuItem i=(MenuItem)ev.getSource();
            String label=i.getLabel();
            //*********Found********
            if (label=="退出")   System.exit(1);    //关闭窗口 // System.exit(1)
            else if (label=="保存") saveFile();
        }
    }

    void saveFile()
    {
        fd=new FileDialog(f,"请输入要保存的文件名",FileDialog.SAVE);
        //*********Found********
        fd.setVisible(true); // true
        fileName=fd.getFile();
        try
        {
            fos=new FileOutputStream(fileName);
            osw=new OutputStreamWriter(fos);
            System.out.println(s);
            osw.write(s);
            osw.flush();
            osw.close();
            fos.close();
        }
        catch(Exception e){}
    }
}
