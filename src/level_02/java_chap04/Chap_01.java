package level_02.java_chap04;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.spi.CalendarNameProvider;

/**
 * 날짜와 시간
 * 프로그램을 만들다 보면
 * 날짜와 시간을 사용하는 경우가 많은데
 * 자바에서는 1.0버전부터 Date 클래스로 그러한 기능을 제공했다.
 *
 * 그러나 Date클래스는 기능이 부족하였고 Calender 클래스를 새로 제공하였다.
 * 그러나 이 2개로도 부족항였고 1.8버전부터 java.time 패키지를 이용하여
 * 더욱 더 다양한 기능들을 제공한다.
 */
public class Chap_01 {

    public static void main(String[] args) {
        /*
         * Canlendar 클래스는 추상클래스이므로 일반적인 방법으로 생성이 불가능하다.
         * 그래서 메서드를 통해서 생성을 해주자.
         */
        Calendar calendar1 = Calendar.getInstance();

        // 만약 나는 캘린더 클래스말고 구현된 클래스를 이용하고 싶다면 이렇게 하면 된다.
        // 나머지 2개의 구현체는 특별한 상황에서만 사용이 되는 것이다.
        Calendar calendar2 = new GregorianCalendar();

        // Date 클래스는 현재는 거의 다 사용을 권장하지 않지만 현역으로써 사용된다.
        Date date1 = new Date();

        // 2개를 변환하는 간단한 방법은 아래와 같다.
        Date date2 = calendar1.getTime();
        Date date3 = new Date(calendar2.getTimeInMillis());
        calendar1.setTime(date1);

        /*
         * 생성하는 법은 위와 같고 사용방법 또한 그렇게 어렵지도 않다.
         */
        Calendar calendar = Calendar.getInstance();
        System.out.println("올 해의 년도 : " + calendar.get(Calendar.YEAR));
        System.out.println("월 가져오기 : " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("이 해의 몇주 : " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("이 달의 몇주 : " + calendar.get(Calendar.WEEK_OF_MONTH));

        System.out.println("이 달의 몇일 : " + calendar.get(Calendar.DATE));
        System.out.println("시간 1 ~ 12 : " + calendar.get(Calendar.HOUR));
        System.out.println("시간 1 ~ 24 : " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("분 0 ~ 59 : " + calendar.get(Calendar.MINUTE));

        System.out.println("밀리세컨드 : " + calendar.get(Calendar.ZONE_OFFSET));
        System.out.println("이 달의 마지막 날 : " + calendar.getActualMaximum(Calendar.DATE));

        /*
         * 이렇게 간단하게 날짜와 시간을 얻어올 수 있다.
         * 중간에 +1을 한 이유는 해당 상수로 가져오는 값의 특성 때문이다.
         * get(상수)를 통해서 시스템의 날짜와 시간을 얻어올 수 있고
         * set을 통하면 설정을 할 수 있다.
         */
        calendar.set(9999, Calendar.MARCH, 17);
        //calendar.set(2007, 2 15); 이렇게 작성해도 상관없다.
        System.out.println(calendar.get(Calendar.YEAR) + " : " + calendar.get(Calendar.MONTH) + " : " + calendar.get(Calendar.DATE));


    }

}
