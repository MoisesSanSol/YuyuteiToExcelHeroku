<html>
<meta charset="utf-8">
<head>
<title>Show progress of long running process with help of Thread and Ajax.</title>
</head>
<body>
<h2></h2>
  <br>Colección:<br>
<br>
<select name="series" form="serieslist">
<option value="dc">D.C./D.C.Ⅱ</option>
<option value="dcext1.0">D.C./D.C.Ⅱ エクストラVol1</option>
<option value="dcext2.0">D.C./D.C.Ⅱ エクストラVol2</option>
<option value="dcpc">D.C./D.C.Ⅱプラスコミュニケーション</option>
<option value="dcext3.0">D.C./D.C.Ⅱ プラスコミュニケーション エクストラ</option>
<option value="dc3">D.C.III</option>
<option value="animedcext1.0">アニメ「D.C.III～ダ・カーポIII～」 エクストラ</option>
<option value="dc10th">D.C. 10thアニバーサリーミックス</option>
<option value="dcsakuraext">D.C. サクラサクパック Extra</option>
<option value="dsdc">「D.S. -Dal Segno-」＆「D.C.III With You ～ダ・カーポIII～ ウィズユー」</option>
<option value="lb">リトルバスターズ!</option>
<option value="lbext1.0">リトルバスターズ! Extra</option>
<option value="lbe">リトルバスターズ! エクスタシー</option>
<option value="animelb">アニメ「リトルバスターズ!」</option>
<option value="animelbrext">アニメ「リトルバスターズ！～Refrain～」Extra</option>
<option value="lbcmext">リトルバスターズ！ カードミッション Extra</option>
<option value="ab">Angel Beats! &amp; クドわふたー</option>
<option value="ab">Angel Beats! &amp; クドわふたー</option>
<option value="abre">Angel Beats! Re: Edit</option>
<option value="abext">AngelBeats! Extra</option>
<option value="abext2.0">AngelBeats! vol.2 Extra</option>
<option value="zm">ゼロの使い魔</option>
<option value="zmf">ゼロの使い魔F</option>
<option value="zmfext">ゼロの使い魔F Extra</option>
<option value="ns">リリカルなのは StrikerS</option>
<option value="nsm">リリカルなのは TheMOVIE 1st</option>
<option value="nsa">リリカルなのは A’s</option>
<option value="nsm2">リリカルなのは TheMOVIE 2nd A’s</option>
<option value="nsm1m2">リリカルなのは The MOVIE 1st ＆ 2nd A’s</option>
<option value="vvs">ViVid Strike!</option>
<option value="ls">らき☆すた</option>
<option value="pr">Phantom</option>
<option value="sh">涼宮ハルヒの憂鬱</option>
<option value="shext">涼宮ハルヒの憂鬱 Extra</option>
<option value="shpset">パワーアップセット　涼宮ハルヒの憂鬱</option>
<option value="ir">禁書目録＆超電磁砲</option>
<option value="ir2.0">禁書目録II＆超電磁砲</option>
<option value="irs">とある科学の超電磁砲S</option>
<option value="irspset">パワーアップセット　とある科学の超電磁砲S</option>
<option value="ss">灼眼のシャナ</option>
<option value="ssext">灼眼のシャナ III-FINAL- Extra</option>
<option value="clext1.0">CLANNAD Vol1</option>
<option value="clext2.0">CLANNAD Vol2</option>
<option value="clext3.0">CLANNAD Vol3</option>
<option value="clpset">パワーアップセット CLANNAD</option>
<option value="rw">Rewrite</option>
<option value="rwhf">Rewrite Harvest festa!</option>
<option value="rwanime">TVアニメ「Rewrite」</option>
<option value="njext">日常</option>
<option value="ddext1.0">DOG DAYS Extra</option>
<option value="ddext2.0">DOG DAYS’Extra</option>
<option value="ddext3.0">DOG DAYS”Extra</option>
<option value="magica">魔法少女まどか☆マギカ</option>
<option value="magicamv">劇場版 魔法少女まどか☆マギカ[新編]叛逆の物語</option>
<option value="symphogear">戦姫絶唱シンフォギア</option>
<option value="symphogearg">戦姫絶唱シンフォギアG</option>
<option value="symphogeargx">戦姫絶唱シンフォギアGX</option>
<option value="robono">ロボティクス・ノーツ</option>
<option value="vivid">ビビッドレッド・オペレーション</option>
<option value="lovelive">ラブライブ！</option>
<option value="lovelive2.0">ラブライブ！Vol.2</option>
<option value="lovelivesif">ラブライブ！ feat.スクールアイドルフェスティバル</option>
<option value="lovelivesif2.0">ラブライブ！ feat.スクールアイドルフェスティバル Vol.2</option>
<option value="lovelivesifvset">ラブライブ！ feat.スクールアイドル フェスティバル バラエティセット</option>
<option value="loveliveext">ラブライブ！ Extra</option>
<option value="lovelivesimext">ラブライブ！ The School Idol Movie Extra</option>
<option value="lovelivess">ラブライブ！サンシャイン!!</option>
<option value="genei">幻影ヲ駆ケル太陽</option>
<option value="nisekoi">ニセコイ</option>
<option value="nisekoiext">ニセコイ: Extra</option>
<option value="gf">ガールフレンド（仮）</option>
<option value="gf2.0">ガールフレンド（仮） Vol.2</option>
<option value="tld2nd">To LOVEる -とらぶる- ダークネス 2nd</option>
<option value="tld2nd2.0">To LOVEる -とらぶる- ダークネス 2nd Vol.2</option>
<option value="charlotte1.0">Charlotte</option>
<option value="imc">アイドルマスター シンデレラガールズ</option>
<option value="imc2nd">アイドルマスター シンデレラガールズ 2nd SEASON</option>
<option value="siyoko">カードゲームしよ子 アルティメットスターター</option>
<option value="gochiusa">ご注文はうさぎですか？？</option>
<option value="gochiusaext">ご注文はうさぎですか？？Extra</option>
<option value="bd">BanG Dream!</option>
<option value="konosuba">Konosuba - この素晴らしい世界に祝福を！</option>
<option value="skext1.0">宇宙をかける少女 Vol.1</option>
<option value="mhext1.0">舞-HiME＆舞-乙HiME Vol.1</option>
<option value="skext2.0">宇宙をかける少女 Vol.2</option>
<option value="mhext2.0">舞-HiME＆舞-乙HiME Vol.2</option>
<option value="p3">ペルソナ3</option>
<option value="p4">ペルソナ4</option>
<option value="animep4">TVアニメ「ペルソナ4」</option>
<option value="p5">ペルソナ５</option>
<option value="p4uext1.0">P4U Extra</option>
<option value="p4ext">ペルソナ4 Extra</option>
<option value="animep4ext1.0">TVアニメ「ペルソナ4」Extra</option>
<option value="pqext">ペルソナQ シャドウ オブ ザ ラビリンス Extra</option>
<option value="dg">魔界戦記ディスガイア</option>
<option value="dgext1.0">魔界戦記ディスガイア4</option>
<option value="dgd2ext">ディスガイアD2 Extra</option>
<option value="fs">Fate/stay night</option>
<option value="fh">Fate/hollow ataraxia</option>
<option value="fz">Fate/Zero</option>
<option value="fsubw">Fate/stay night [Unlimited Blade Works]</option>
<option value="fsubw2.0">Fate/stay night [Unlimited Blade Works] Vol.II</option>
<option value="fzext">Fate/Zero Extra</option>
<option value="fpi">Fate/kaleid liner プリズマ☆イリヤ Extra</option>
<option value="fpi2.0">Fate/kaleid liner プリズマ☆イリヤ ツヴァイ! Extra</option>
<option value="fpi2.0helz">Fate/kaleid liner プリズマ☆イリヤ ツヴァイ ヘルツ！</option>
<option value="se">シャイニング・フォース イクサ</option>
<option value="sre">シャイニング・レゾナンス</option>
<option value="kf">ザ・キング・オブ・ファイターズ</option>
<option value="sb">戦国BASARA</option>
<option value="sbext1.0">戦国BASARA弐</option>
<option value="im">THE IDOLM@STER</option>
<option value="imd">THE IDOLM@STER Deary Stars</option>
<option value="im2.0">THE IDOLM@STER2</option>
<option value="animeim">アニメ「アイドルマスター」</option>
<option value="imm">劇場版「THE IDOLM@STER MOVIE 輝きの向こう側へ！」</option>
<option value="im765proext">アイドルマスター ミニキャラパック 『765pro』 Extra</option>
<option value="impset">パワーアップセット アイドルマスター</option>
<option value="ft">FAIRY TAIL</option>
<option value="ftext1.0">FAIRY TAIL Extra</option>
<option value="mb">MELTY BLOOD</option>
<option value="eva">ヱヴァンゲリヲン新劇場版</option>
<option value="tmh">探偵オペラ ミルキィホームズ</option>
<option value="tmh2.0">探偵オペラ ミルキィホームズ2</option>
<option value="tmh2nd">探偵オペラ ミルキィホームズ セカンドステージエディション</option>
<option value="tmhext">探偵オペラ ミルキィホームズ 怪盗帝国の逆襲</option>
<option value="tmhext2.0">探偵オペラ ミルキィホームズ G4の反撃</option>
<option value="tmhmovie">劇場版 探偵オペラ ミルキィホームズ ～逆襲のミルキィホームズ～</option>
<option value="tmhffpp">ミルキィホームズ ファンファンパーリーパック♪</option>
<option value="brext1.0">ブラック★ロックシューター Extra</option>
<option value="katanaext">刀語 Extra</option>
<option value="bake">化物語</option>
<option value="nisem">偽物語</option>
<option value="monogatari2nd">&lt;物語&gt;シリーズ セカンドシーズン</option>
<option value="mfi">劇場版マクロスF</option>
<option value="gc">ギルティクラウン</option>
<option value="aw">アクセル・ワールド</option>
<option value="awib">アクセル・ワールド -インフィニット・バースト-</option>
<option value="sao">ソードアート・オンライン</option>
<option value="sao2.0">ソードアート・オンライン vol.2</option>
<option value="saore">ソードアート・オンライン Re：Edit</option>
<option value="sao2ext">ソードアート・オンラインII Extra</option>
<option value="sao2ext2.0">ソードアート・オンラインII Extra Vol.2</option>
<option value="kk">空の境界</option>
<option value="ca">CANAAN</option>
<option value="miku">初音ミク -Project DIVA- f</option>
<option value="miku2.0">初音ミク -Project DIVA- f 2nd</option>
<option value="ppext">PSYCHO-PASS Extra</option>
<option value="gargan">翠星のガルガンティア</option>
<option value="ds2ext">TVアニメ「デビルサバイバー2」 Extra</option>
<option value="kill">キルラキル</option>
<option value="killpset">パワーアップセット　キルラキル</option>
<option value="logho">ログ・ホライズン Extra</option>
<option value="loghopset">パワーアップセット ログ・ホライズン</option>
<option value="kancolle">艦隊これくしょん -艦これ-</option>
<option value="kancolle2.0">艦隊これくしょん -艦これ- 第二艦隊</option>
<option value="kancolle3.0">艦隊これくしょん -艦これ- 到着！欧州からの増派艦隊</option>
<option value="kancolleext">艦隊これくしょん -艦これ- 深海棲艦見ゆ Extra</option>
<option value="shinchan">クレヨンしんちゃん</option>
<option value="gstext">超爆裂異次元メンコバトル ギガントシューターつかさ Extra</option>
<option value="tf">テラフォーマーズ</option>
<option value="aot">進撃の巨人</option>
<option value="sgs">スクールガールストライカーズ</option>
<option value="puyopuyo">ぷよぷよ</option>
<option value="oms">おそ松さん</option>
<option value="rinneext">境界のRINNE Extra</option>
<option value="kiznaiver">キズナイーバー</option>
<option value="rz">Re：ゼロから始める異世界生活</option>
<option value="chain">チェインクロニクル ～ヘクセイタスの閃～</option>
<option value="woo">うーさーのその日暮らし</option>
<option value="promo">その他プロモーションカード</option>

</select>
<form action="/yyt2xls" method="post" id="serieslist">
<br>
  <input type="submit" value="Generar Excel"><br><br>
  <input type="checkbox" name="paralelas" value = "true" checked="yes">Incluir paralelas<br>
  <input type="checkbox" name="trial" value = "true" checked="yes">Incluir trial deck<br>
  <input type="checkbox" name="promocionales" value = "true" checked="yes">Incluir promocionales<br>
   <input type="checkbox" name="imagenes" value = "true">(*) Incluir imágenes<br>
   <p>(*) Debido a un limite de tiempo al procesor respuesta, el excel con imágenes falla casi siempre para colecciones más agrandes de un extra booster (sin paralelas), cuando tenga tiempo miraré como evitarlo.</p>
<p>Dependiendo del número de cartas en el set la generación con imágenes puede tardar varios minutos (si no falla directamente).</p>
   <p>Tengo pendiente incluir una columna con el color de las cartas, ya que en la página de set de yuytei no está definido el color de las cartas.</p>
   <p>Tengo pendiente traducir el selector en vez de usar los nombres yuytei (si alguien se anima en hacerlo y pasarme la relación, bienvenido sea).</p>
</form>
</body>
</html>
