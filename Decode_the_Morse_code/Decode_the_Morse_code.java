public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
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