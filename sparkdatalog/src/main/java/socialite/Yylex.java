// This JLex file was machine-generated by the BNF converter
package socialite;
import java_cup.runtime.*;


public class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

  String pstring = new String();
  public int line_num() { return (yyline+1); }
  public String buff() { return new String(yy_buffer,yy_buffer_index,10).trim(); }
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int STRING = 5;
	private final int ESCAPED = 6;
	private final int YYINITIAL = 0;
	private final int COMMENT = 1;
	private final int CHAREND = 4;
	private final int CHARESC = 3;
	private final int CHAR = 2;
	private final int yy_state_dtrans[] = {
		0,
		48,
		49,
		49,
		49,
		49,
		49
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NOT_ACCEPT,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NOT_ACCEPT,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NOT_ACCEPT,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NOT_ACCEPT,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NOT_ACCEPT,
		/* 45 */ YY_NOT_ACCEPT,
		/* 46 */ YY_NOT_ACCEPT,
		/* 47 */ YY_NOT_ACCEPT,
		/* 48 */ YY_NOT_ACCEPT,
		/* 49 */ YY_NOT_ACCEPT,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"29:9,35,28,29,35,27,29:18,35,8,29,26,34,29:3,3,4,12,11,5,7,1,13,32:10,6,29," +
"10,2,9,29:2,30:26,29:4,33,29,14,31,19,23,17,31,15,31,25,31:2,24,31,21,20,31" +
":2,16,22,18,31:6,29:69,30:23,29,30:7,31:24,29,31:8,29:65280,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,67,
"0,1:2,2,1:4,3,4,1:2,5,6,1,7,8,1:7,9,1,10,11,10:3,1:3,12,13,14,15,16,17,18,1" +
"9,20,21,22,23,24,14,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,10:2")[0];

	private int yy_nxt[][] = unpackFromString(42,36,
"1,2,3,4,5,6,34,7,38,8,9,10,11,12,13,66:4,57,66:3,62,66,50,40,14:2,-1,15,66," +
"16,-1,42,14,-1:38,17,-1:35,20,-1:35,21,-1:45,22,44,-1:36,66,64,66:10,-1:4,6" +
"5,66,65:2,-1:16,15:12,-1:4,15:4,-1:3,45,-1:30,16,-1:17,24:12,-1:4,24:4,-1:1" +
"6,66:12,-1:4,65,66,65:2,-1:19,46,-1:14,27,-1:10,18,-1:42,66:4,26,66:7,-1:4," +
"65,66,65:2,-1:34,36,-1:16,33,-1:24,19,-1:47,66:4,28,66:7,-1:4,65,66,65:2,-1" +
":3,40:27,23,40:7,-1:14,66:3,29,66:8,-1:4,65,66,65:2,-1:32,24,-1:19,66:3,30," +
"66:8,-1:4,65,66,65:2,-1:3,44:27,25,44:7,-1:32,27,-1:10,47,-1:24,36,-1:3,1,3" +
"1:11,37,31:14,-1,32,31:7,1,-1:49,66:7,35,66:4,-1:4,65,66,65:2,-1:16,66:8,39" +
",66:3,-1:4,65,66,65:2,-1:16,66:2,41,66:9,-1:4,65,66,65:2,-1:16,66:4,43,66:7" +
",-1:4,65,66,65:2,-1:16,66:7,51,66:4,-1:4,65,66,65:2,-1:16,52,66:11,-1:4,65," +
"66,65:2,-1:16,53,66:11,-1:4,65,66,65:2,-1:16,66:6,54,66:5,-1:4,65,66,65:2,-" +
"1:16,66:10,55,66,-1:4,65,66,65:2,-1:16,66,56,66:10,-1:4,65,66,65:2,-1:16,66" +
":5,58,66:6,-1:4,65,66,65:2,-1:16,66:3,59,66:8,-1:4,65,66,65:2,-1:16,66:3,60" +
",66:8,-1:4,65,66,65:2,-1:16,66:2,61,66:9,-1:4,65,66,65:2,-1:16,66,63,66:10," +
"-1:4,65,66,65:2,-1:2");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{ return new Symbol(sym._SYMB_0); }
					case -3:
						break;
					case 3:
						{ return new Symbol(sym._SYMB_1); }
					case -4:
						break;
					case 4:
						{ return new Symbol(sym._SYMB_2); }
					case -5:
						break;
					case 5:
						{ return new Symbol(sym._SYMB_3); }
					case -6:
						break;
					case 6:
						{ return new Symbol(sym._SYMB_4); }
					case -7:
						break;
					case 7:
						{ return new Symbol(sym._SYMB_13); }
					case -8:
						break;
					case 8:
						{ return new Symbol(sym._SYMB_8); }
					case -9:
						break;
					case 9:
						{ return new Symbol(sym._SYMB_9); }
					case -10:
						break;
					case 10:
						{ return new Symbol(sym._SYMB_12); }
					case -11:
						break;
					case 11:
						{ return new Symbol(sym._SYMB_14); }
					case -12:
						break;
					case 12:
						{ return new Symbol(sym._SYMB_15); }
					case -13:
						break;
					case 13:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -14:
						break;
					case 14:
						{ /* ignore white space. */ }
					case -15:
						break;
					case 15:
						{ return new Symbol(sym.UIdent, yytext().intern()); }
					case -16:
						break;
					case 16:
						{ return new Symbol(sym._INTEGER_, new Integer(yytext())); }
					case -17:
						break;
					case 17:
						{ return new Symbol(sym._SYMB_6); }
					case -18:
						break;
					case 18:
						{ return new Symbol(sym._SYMB_5); }
					case -19:
						break;
					case 19:
						{ return new Symbol(sym._SYMB_7); }
					case -20:
						break;
					case 20:
						{ return new Symbol(sym._SYMB_10); }
					case -21:
						break;
					case 21:
						{ return new Symbol(sym._SYMB_11); }
					case -22:
						break;
					case 22:
						{ yybegin(COMMENT); }
					case -23:
						break;
					case 23:
						{ /* BNFC single-line comment */ }
					case -24:
						break;
					case 24:
						{ return new Symbol(sym.DIdent, yytext().intern()); }
					case -25:
						break;
					case 25:
						{ /* BNFC single-line comment */ }
					case -26:
						break;
					case 26:
						{ return new Symbol(sym._SYMB_19); }
					case -27:
						break;
					case 27:
						{ return new Symbol(sym._DOUBLE_, new Double(yytext())); }
					case -28:
						break;
					case 28:
						{ return new Symbol(sym._SYMB_17); }
					case -29:
						break;
					case 29:
						{ return new Symbol(sym._SYMB_18); }
					case -30:
						break;
					case 30:
						{ return new Symbol(sym._SYMB_16); }
					case -31:
						break;
					case 31:
						{ }
					case -32:
						break;
					case 32:
						{ }
					case -33:
						break;
					case 33:
						{ yybegin(YYINITIAL); }
					case -34:
						break;
					case 35:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -35:
						break;
					case 36:
						{ return new Symbol(sym._DOUBLE_, new Double(yytext())); }
					case -36:
						break;
					case 37:
						{ }
					case -37:
						break;
					case 39:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -38:
						break;
					case 41:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -39:
						break;
					case 43:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -40:
						break;
					case 50:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -41:
						break;
					case 51:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -42:
						break;
					case 52:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -43:
						break;
					case 53:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -44:
						break;
					case 54:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -45:
						break;
					case 55:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -46:
						break;
					case 56:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -47:
						break;
					case 57:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -48:
						break;
					case 58:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -49:
						break;
					case 59:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -50:
						break;
					case 60:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -51:
						break;
					case 61:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -52:
						break;
					case 62:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -53:
						break;
					case 63:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -54:
						break;
					case 64:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -55:
						break;
					case 65:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -56:
						break;
					case 66:
						{ return new Symbol(sym.LIdent, yytext().intern()); }
					case -57:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
