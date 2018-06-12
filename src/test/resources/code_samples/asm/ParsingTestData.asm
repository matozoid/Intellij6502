
*       = $0801
        .word (+), 2005  ;pointer, line number
        .null $9e, format("%d", start);will be sys 4096
+	.word 0          ;basic line end

*       = $1000

abc     := 5



start	rts

jumpcmd lda hibytes,x   ; selected routine in X register
        pha
        lda lobytes,x   ; push address to stack
        pha
        rts             ; jump, rts will increase pc by one!
; Build an anonymous list of jump addresses minus 1
-	= (cmd_p, cmd_c, cmd_m, cmd_s, cmd_r, cmd_l, cmd_e)-1
lobytes .byte <(-)      ; low bytes of jump addresses
hibytes .byte >(-)      ; high bytes



        .byte 23        ; decimal

        lda #((bitmap >> 10) & $0f) | ((screen >> 6) & $f0)
        sta $d018

        .byte $33       ; hex
        .byte %00011111 ; binary
        .text $1234     ; $34, $12

        lda $01
        and #~$07
        ora #$05
        sta $01

        lda $d015
        and #~%00100000 ;clear a bit
        sta $d015

        .byte 3.66e1       ; 36.6, truncated to 36
        .byte $1.8p4       ; 4:4 fixed point number (1.5)
        .sint 12.2p8       ; 8:8 fixed point number (12.2)
        .sint %10.10p8       ; 8:8 fixed point number (12.2)

mystr   = "oeU"         ; text
        .text 'it''s'   ; text: it's
        .text "it""s"   ; text: it's
        .word "ab"+1    ; character, results in "bb" usually

        .text "text"[:2]     ; "te"
        .text "text"[2:]     ; "xt"
        .text "text"[:-1]    ; "tex"
        .text "reverse"[::-1]; "esrever"


.enc "screen"	;use screen encoding
mystr   = b"oeU"        ;convert text to bytes, like .text
        .enc "none"	;normal encoding

        .text mystr     ;text as originally encoded
        .text s"p1"     ;convert to bytes like .shift
        .text l"p2"     ;convert to bytes like .shiftl
        .text n"p3"     ;convert to bytes like .null
        .text p"p4"     ;convert to bytes like .ptext


mylist  = [1, 2, "whatever"]
mytuple = (cmd_e, cmd_g)

mylist  = ("e", cmd_e, "g", cmd_g, "i", cmd_i)
keys    .text mylist[::2]    ; keys ("e", "g", "i")
call_l  .byte <mylist[1::2]-1; routines (<cmd_e−1, <cmd_g−1, <cmd_i−1)
call_h  .byte >mylist[1::2]-1; routines (>cmd_e−1, >cmd_g−1, >cmd_i−1)

;Bitmask table, 8 bits from left to right
        .byte %10000000 >> range(8)
;Classic 256 byte single period sinus table with values of 0−255.
        .byte 128.5 + 127 * sin(range(256) * rad(360.0/256))
;Screen row address tables
-       = $400 + range(0, 1000, 40)
scrlo   .byte <(-)
scrhi   .byte >(-)


; Simple lookup
        .text {1:"one", 2:"two"}[2]; "two"
; 16 element "fader" table 1->15->12->11->0
        .byte {1:15, 15:12, 12:11, :0}[range(16)]


mydata  .word 1, 4, 3
mycode  .block
local   lda #0
        .bend

        ldx #size(mydata) ;6 bytes (3∗2)
        ldx #len(mydata)  ;3 elements
        ldx #mycode[0]    ;lda instruction, $a9
        ldx #mydata[1]    ;2nd element, 4
        jmp mycode.local  ;address of local label


   .cerror type(var) != str, "Not a string!"
        .text str(year)   ; convert to string

; sort IRQ routines by their raster lines
sorted  = sort([(60, irq1), (50, irq2)])
lines   .byte sorted[:, 0] ; 50, 60
irqs    .addr sorted[:, 1] ; irq2,
