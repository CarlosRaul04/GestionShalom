PGDMP  '                     |            ShalomDB    16.4    16.4 .    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24689    ShalomDB    DATABASE     |   CREATE DATABASE "ShalomDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Peru.1252';
    DROP DATABASE "ShalomDB";
                postgres    false            �            1259    24702    destino    TABLE     �   CREATE TABLE public.destino (
    id integer NOT NULL,
    departamento character varying(100) NOT NULL,
    ciudad character varying(100) NOT NULL,
    direccion character varying(255) NOT NULL
);
    DROP TABLE public.destino;
       public         heap    postgres    false            �            1259    24701    destino_id_seq    SEQUENCE     �   CREATE SEQUENCE public.destino_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.destino_id_seq;
       public          postgres    false    218            �           0    0    destino_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.destino_id_seq OWNED BY public.destino.id;
          public          postgres    false    217            �            1259    24776    gestion_inventario    TABLE     �  CREATE TABLE public.gestion_inventario (
    id integer NOT NULL,
    producto_id character(6) NOT NULL,
    inventario_id integer DEFAULT 1 NOT NULL,
    origen character varying(255) DEFAULT 'Lima'::character varying,
    destino_id integer,
    cantidad integer,
    estado_producto character varying(50) DEFAULT 'En almacén'::character varying,
    descripcion text,
    fecha_entrada timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    fecha_salida_max date,
    tiempo_excedente integer
);
 &   DROP TABLE public.gestion_inventario;
       public         heap    postgres    false            �            1259    24775    gestion_inventario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.gestion_inventario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.gestion_inventario_id_seq;
       public          postgres    false    225            �           0    0    gestion_inventario_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.gestion_inventario_id_seq OWNED BY public.gestion_inventario.id;
          public          postgres    false    224            �            1259    24711 
   inventario    TABLE     �   CREATE TABLE public.inventario (
    id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    ubicacion character varying(100)
);
    DROP TABLE public.inventario;
       public         heap    postgres    false            �            1259    24710    inventario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.inventario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.inventario_id_seq;
       public          postgres    false    220            �           0    0    inventario_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.inventario_id_seq OWNED BY public.inventario.id;
          public          postgres    false    219            �            1259    24730    notificaciones    TABLE     �   CREATE TABLE public.notificaciones (
    id integer NOT NULL,
    mensaje text NOT NULL,
    fecha timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 "   DROP TABLE public.notificaciones;
       public         heap    postgres    false            �            1259    24729    notificaciones_id_seq    SEQUENCE     �   CREATE SEQUENCE public.notificaciones_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.notificaciones_id_seq;
       public          postgres    false    222            �           0    0    notificaciones_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.notificaciones_id_seq OWNED BY public.notificaciones.id;
          public          postgres    false    221            �            1259    24743    producto    TABLE       CREATE TABLE public.producto (
    id character(6) NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion text,
    peso numeric(10,2),
    medidas character varying(100),
    precio numeric(10,2),
    estado character varying(20) DEFAULT 'Activo'::character varying
);
    DROP TABLE public.producto;
       public         heap    postgres    false            �            1259    24691    usuario    TABLE     z  CREATE TABLE public.usuario (
    id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    correo character varying(150) NOT NULL,
    telefono character varying(9),
    "contraseña" character varying(50) NOT NULL,
    rol character varying(50) DEFAULT 'Administrador'::character varying,
    fecha_creacion timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    24690    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    216            �           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    215            5           2604    24705 
   destino id    DEFAULT     h   ALTER TABLE ONLY public.destino ALTER COLUMN id SET DEFAULT nextval('public.destino_id_seq'::regclass);
 9   ALTER TABLE public.destino ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    218    218            :           2604    24779    gestion_inventario id    DEFAULT     ~   ALTER TABLE ONLY public.gestion_inventario ALTER COLUMN id SET DEFAULT nextval('public.gestion_inventario_id_seq'::regclass);
 D   ALTER TABLE public.gestion_inventario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    225    225            6           2604    24714    inventario id    DEFAULT     n   ALTER TABLE ONLY public.inventario ALTER COLUMN id SET DEFAULT nextval('public.inventario_id_seq'::regclass);
 <   ALTER TABLE public.inventario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    220    220            7           2604    24733    notificaciones id    DEFAULT     v   ALTER TABLE ONLY public.notificaciones ALTER COLUMN id SET DEFAULT nextval('public.notificaciones_id_seq'::regclass);
 @   ALTER TABLE public.notificaciones ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    221    222            2           2604    24694 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    216    216            �          0    24702    destino 
   TABLE DATA           F   COPY public.destino (id, departamento, ciudad, direccion) FROM stdin;
    public          postgres    false    218   �6       �          0    24776    gestion_inventario 
   TABLE DATA           �   COPY public.gestion_inventario (id, producto_id, inventario_id, origen, destino_id, cantidad, estado_producto, descripcion, fecha_entrada, fecha_salida_max, tiempo_excedente) FROM stdin;
    public          postgres    false    225   l9       �          0    24711 
   inventario 
   TABLE DATA           ;   COPY public.inventario (id, nombre, ubicacion) FROM stdin;
    public          postgres    false    220   
;       �          0    24730    notificaciones 
   TABLE DATA           <   COPY public.notificaciones (id, mensaje, fecha) FROM stdin;
    public          postgres    false    222   C;       �          0    24743    producto 
   TABLE DATA           Z   COPY public.producto (id, nombre, descripcion, peso, medidas, precio, estado) FROM stdin;
    public          postgres    false    223   `;       �          0    24691    usuario 
   TABLE DATA           c   COPY public.usuario (id, nombre, correo, telefono, "contraseña", rol, fecha_creacion) FROM stdin;
    public          postgres    false    216   =       �           0    0    destino_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.destino_id_seq', 200, true);
          public          postgres    false    217            �           0    0    gestion_inventario_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.gestion_inventario_id_seq', 54, true);
          public          postgres    false    224            �           0    0    inventario_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.inventario_id_seq', 7, true);
          public          postgres    false    219            �           0    0    notificaciones_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.notificaciones_id_seq', 1, false);
          public          postgres    false    221            �           0    0    usuario_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.usuario_id_seq', 8, true);
          public          postgres    false    215            D           2606    24709    destino destino_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.destino
    ADD CONSTRAINT destino_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.destino DROP CONSTRAINT destino_pkey;
       public            postgres    false    218            L           2606    24786 *   gestion_inventario gestion_inventario_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.gestion_inventario
    ADD CONSTRAINT gestion_inventario_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.gestion_inventario DROP CONSTRAINT gestion_inventario_pkey;
       public            postgres    false    225            F           2606    24716    inventario inventario_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.inventario
    ADD CONSTRAINT inventario_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.inventario DROP CONSTRAINT inventario_pkey;
       public            postgres    false    220            H           2606    24738 "   notificaciones notificaciones_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.notificaciones
    ADD CONSTRAINT notificaciones_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.notificaciones DROP CONSTRAINT notificaciones_pkey;
       public            postgres    false    222            J           2606    24750    producto producto_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_pkey;
       public            postgres    false    223            @           2606    24700    usuario usuario_correo_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_correo_key UNIQUE (correo);
 D   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_correo_key;
       public            postgres    false    216            B           2606    24698    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    216            M           2606    24797 5   gestion_inventario gestion_inventario_destino_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.gestion_inventario
    ADD CONSTRAINT gestion_inventario_destino_id_fkey FOREIGN KEY (destino_id) REFERENCES public.destino(id);
 _   ALTER TABLE ONLY public.gestion_inventario DROP CONSTRAINT gestion_inventario_destino_id_fkey;
       public          postgres    false    218    225    4676            N           2606    24792 8   gestion_inventario gestion_inventario_inventario_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.gestion_inventario
    ADD CONSTRAINT gestion_inventario_inventario_id_fkey FOREIGN KEY (inventario_id) REFERENCES public.inventario(id);
 b   ALTER TABLE ONLY public.gestion_inventario DROP CONSTRAINT gestion_inventario_inventario_id_fkey;
       public          postgres    false    225    220    4678            O           2606    24787 6   gestion_inventario gestion_inventario_producto_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.gestion_inventario
    ADD CONSTRAINT gestion_inventario_producto_id_fkey FOREIGN KEY (producto_id) REFERENCES public.producto(id);
 `   ALTER TABLE ONLY public.gestion_inventario DROP CONSTRAINT gestion_inventario_producto_id_fkey;
       public          postgres    false    223    225    4682            �   ]  x�US�n�0<S_�_��C�Qq[ԁ��{�eM1Zt)1�}����O��XG��8:���`gwf)�(�|��b�c��?"w4\��F��s���4�;�=r��(_�h�k*���i<�T��C{޳冁?�;g�+Zrh�sEy��U��w��Hޱӌv�b��Ld����:ꝿI���Wuc��m���,̀�(��{�o�n�{�ڷ�F)F*�������}u��&4�������Z�!����q=N�	0�N��j�ϧCG:�B�Pi�4M�T1��[E}O:����}�T{f��Щ���\�YC�"-p���XA�+����?;R)T.
�`Z�F�X��b��P���-��N�P�~�Gxa�V��ރ��7�g��%�D�T,�/�+���t��Y~*�0BI���4^��o����ls��-ɑ�*K�C[C_,�W��`	���?AH�%R#����9�Gr��&9��I�Ŋ{M�+s9~L�����Cj"V6�Ǝ�>�9ѥ��%�QS�Z�K�K����\�l><�M'�I�b'pZ�.U���k�Io�F)%�q�1���ۻ��ʁ �L�4��x@hL��p�)�XS�/y�K��?6�C�      �   �  x���KN�0 �u�> �\v9��!$�z�r6&f��qwZ��bN�����$GY�z�I؈xH��ڎ��A���fM����&����=���h��߆���)$�WXs��X��:�(*��+��2R	Rj��7����+s>��2CB���lP6Z�K��N����d���%c��� �U��2�P-W&���"E�fT'��J��bC~�n0Oe=��5�i2���w��t��`qZ��h�A��>��4�L��@�	�<Z?&�s�2����<�xp�v����u��f��Y�c�ˊ% �i�Q}/��J_��*c��&z�>�{s��K	.�z>ߞ�U��f:-:�ǹ�������e�>�����.Z;{7�RZw̫�~�.gc9��S��$�J&      �   )   x�3���+K�+I,��W���M�:
�E�wq��qqq Զ1      �      x������ � �      �   �  x�u�Kn�0E��*��
��a�UUv��P����Q�э��Z�]�B�����8�(:(Y��*�̽��ޫ�ܘ�4J	bDS�S,Z���4��&'aN9B�K5��J��Sb'])���z�È�I'\KML�q4���äN�
bV�D9����@��Ȝpd��0L(D�y��N�	B6���'�e���i�A��D�)ՙ�$�,S��!;eJ�|��P�{%N�2�0H��&���Y_�G��zl�WX���8I,���|���5}C�CDv�W�M���Wg���փ�qu���u��+���� �J[-��OR՟�����䷮i�����UI�o����3�e�8�E�56�5���R��
pOWݥ5W�s+:���}�&���16      �   [   x���tN,��/�LS鹉�9z�����&�f&��`���ǔ�̼�⒢Ĕ�"N##]CC]Csc+C+S=SsK3K�=... ��     