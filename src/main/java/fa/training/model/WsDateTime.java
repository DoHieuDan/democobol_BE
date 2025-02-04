package fa.training.model;

import fa.training.lib.constants.ValueConst;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WsDateTime {

  private short wsCurdateYear;
  private short wsCurdateMonth;
  private short wsCurdateDay;
  private short wsCurtimeHours;
  private short wsCurtimeMinute;
  private short wsCurtimeSecond;
  private short wsCurtimeMilsec;
  private short wsCurdateMm;
  private String filler1;
  private short wsCurdateDd;
  private String filler2;
  private short wsCurdateYy;
  private short wsCurtimeHh;
  private String filler1OfWsCurtimeHhMmSs;
  private short wsCurtimeMm;
  private String filler2OfWsCurtimeHhMmSs;
  private short wsCurtimeSs;
  private short wsTimestampDtYyyy;
  private String filler1OfWsTimestamp;
  private short wsTimestampDtMm;
  private String filler2OfWsTimestamp;
  private short wsTimestampDtDd;
  private String filler3;
  private short wsTimestampTmHh;
  private String filler4;
  private short wsTimestampTmMm;
  private String filler5;
  private short wsTimestampTmSs;
  private String filler6;
  private int wsTimestampTmMs6;
   
  public  WsDateTime(){
      wsCurdateYear = (short)0;
      wsCurdateMonth = (short)0;
      wsCurdateDay = (short)0;
      wsCurtimeHours = (short)0;
      wsCurtimeMinute = (short)0;
      wsCurtimeSecond = (short)0;
      wsCurtimeMilsec = (short)0;
      wsCurdateMm = (short)0;
      filler1 = ValueConst.SPACE;
      wsCurdateDd = (short)0;
      filler2 = ValueConst.SPACE;
      wsCurdateYy = (short)0;
      wsCurtimeHh = (short)0;
      filler1OfWsCurtimeHhMmSs = ValueConst.SPACE;
      wsCurtimeMm = (short)0;
      filler2OfWsCurtimeHhMmSs = ValueConst.SPACE;
      wsCurtimeSs = (short)0;
      wsTimestampDtYyyy = (short)0;
      filler1OfWsTimestamp = ValueConst.SPACE;
      wsTimestampDtMm = (short)0;
      filler2OfWsTimestamp = ValueConst.SPACE;
      wsTimestampDtDd = (short)0;
      filler3 = ValueConst.SPACE;
      wsTimestampTmHh = (short)0;
      filler4 = ValueConst.SPACE;
      wsTimestampTmMm = (short)0;
      filler5 = ValueConst.SPACE;
      wsTimestampTmSs = (short)0;
      filler6 = ValueConst.SPACE;
      wsTimestampTmMs6 = 0;
  }
}