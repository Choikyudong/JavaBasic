package level_02.java_chap03;

import java_forChap.FilePath;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * File
 * 자바 실무에서 정말로 많이 사용하는 클래스이다.
 * 이름에서 알 수 있는것처럼 파일에 대한 기능들을 담당한다.
 */
public class Chap_08 {

    public static void main(String[] args) throws IOException {
        FilePath filePath = FilePath.PATH;

        // File 객체를 생성할 때 경로를 지정하여 생성이 가능하다.
        File file = new File(filePath.getPath() + "/File.txt");

        // 확장자를 포함한 파일 이름 가져오기
        String getFileName = file.getName();

        // 확장자를 제외한 파일 이름 가져오기
        int getSom = getFileName.lastIndexOf(".");
        String getFileSom = getFileName.substring(0, getSom);

        // 경로를 포함한 파일이름
        String getFileAndPath = file.getPath();

        // 파일의 절대경로
        String getFileAPath = file.getAbsolutePath();

        // 파일의 정규경로(상대경로)
        String getFileCPath = file.getCanonicalPath();

        /**
         * 절대경로와 정규경로의 차이점
         *
         * 절대경로는 최초의 시작점으로 경유한 모든 경로를 기업하는 방식
         * 즉 절대경로는 최상위 디렉토리를 꼭 포함하여 시작하는 방식
         *
         * 정규경로, 상대경로라고 많이 불린다. 해당 방식에서는 비교 대상이라는 개념이 중요하다.
         * 현재 디렉토리를 기준으로 작성된 경로를 말한다.
         */

        // 해당 파일이 속한 디렉토리
        String getDi = file.getParent();

        // 해당 OS에서 사용하는 경로 구분자. (윈도우 ;) (유닉스 :)
        String pathSepString = File.pathSeparator;
        char pathSepChar = File.pathSeparatorChar;

        // 해당 OS에서 사용하는 이름 구분자. (윈도우 \) (유닉스 /)
        String sepString = File.separator;
        char sepChar = File.separatorChar;

        useFileMethod();

        /**
         * 간단하게 파일 클래스에 대해서 알아보았는데
         * 밑의 예시는 정말 몇개 사용하지 않은 예시이다.
         * 다음번에 조금 더 알아보자.
         */

    }

    static void useFileMethod() {
        FilePath filePath = FilePath.PATH;
        File file = new File("여긴 어디? 난 누구?");

        // exists() : 해당 파일이 존재하는지 확인한다.
        if (!(file.exists())) {
            System.out.println("넌 누구냐?!");
        }

        File getPath = new File(filePath.getPath());
        
        // isDirectory() : 디렉토리인지 확인한다.
        if (getPath.isDirectory()) {
            System.out.println("멀쩡하네요");
        }
        
        // 해당 경로의 파일들의 목록을 가져온다.
        File[] files = getPath.listFiles();

        for (int i = 0; i < files.length; i++) {
            System.out.println(i + "번째 파일이름 " + files[i].getName());
        }

        // canExecute() : 실행할 수 있는 파일여부 확인
        if (files[0].canExecute()) {
            System.out.println("멀쩡한데요?");
        }

    }

}
