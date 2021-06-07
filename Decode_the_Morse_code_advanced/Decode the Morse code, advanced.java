import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MorseCodeDecoder {
    public static String decodeBits(String bits) {
      System.out.println(bits);
      // clear start 0's
      while(bits.startsWith("0")){
        bits = bits.substring(1);
      }
      // clear end 0's
      while(bits.endsWith("0")){
        bits = bits.substring(0,bits.length()-1);
      }
      System.out.println("bits_check     "+bits);  

      int n_unit = 2;
      int min_char = 100;
      int m_start = 0;
      int m_end = 0;
      
      Pattern  ptrn = Pattern.compile("0+|1+");
      Matcher mbits = ptrn.matcher(bits);
      while (mbits.find()){
        m_start = mbits.start();
        m_end = mbits.end();
        if (min_char > m_end-m_start){
          min_char = m_end - m_start;
        }
      }
      if (min_char == 0){
        n_unit = 1;
      }
      n_unit = min_char;
      
      System.out.println("min_char "+min_char);   
      System.out.println("unit "+n_unit);
      
      String s_return = bits.replaceAll("0{"+(7*n_unit)+",}", "  ");
      s_return = s_return.replaceAll("1{"+(3*n_unit + 1)+",}", ".");
      s_return = s_return.replaceAll("1{"+(3*n_unit)+"}", "-");
      s_return = s_return.replaceAll("1+",".");
      s_return = s_return.replaceAll("0{"+(3*n_unit)+",}", " ");
      s_return = s_return.replaceAll("0+", "");
      return s_return;
    }
    
    public static String decodeMorse(String morseCode) {
      System.out.println(morseCode);
      String[] morse_arr = morseCode.split(" ");
      String s_ret_morse = "";
      boolean b_pre_space = false;
      for(String s_morse_word : morse_arr){
        if (s_morse_word.isEmpty()){
          if (b_pre_space){
            continue;
          }else{
            s_ret_morse += " ";
            b_pre_space = true;
          }
        }else{
          s_ret_morse += MorseCode.get(s_morse_word);
          b_pre_space = false;
        }
      }
      return s_ret_morse.trim();
    }
}