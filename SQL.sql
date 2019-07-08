drop table S_Room cascade constraints;
drop table S_RoomType cascade constraints;
drop table S_Customer cascade constraints;
drop table S_CustomerType cascade constraints;
drop table S_Reservation cascade constraints;
drop table S_ReservationDetail cascade constraints;
drop table S_Bill cascade constraints;
drop table S_BillDetail cascade constraints;
drop table S_Employee cascade constraints;
drop table S_Regulation cascade constraints;

drop trigger tg_Insert_Reservation;
drop trigger tg_Insert_ReservationDetail;
drop trigger tg_Delete_ReservationDetail;
drop trigger tg_Update_ReservationDetail;



create table S_Room (
    RoomID nvarchar2(5) primary key,
    RoomNumber nvarchar2(4) unique,
    Floor number(2),
    RoomTypeID nvarchar2(4),
    Status nvarchar2(20)
);

create table S_RoomType(
    RoomTypeID nvarchar2(4) primary key,
    RoomTypeName nvarchar2(20) unique,
    NumberBeds number(1),
    RoomRate number(10)
);

create table S_Customer (
    CustomerID nvarchar2(10) primary key,
    CustomerTypeID nvarchar2(4),
    FullName nvarchar2(50),
    Gender nvarchar2(20),
    IDCardNumber number(9) unique,
    Address nvarchar2(50),
    Point number(10),
    Status nvarchar2(20)
);

create table S_CustomerType (
    CustomerTypeID nvarchar2(4) primary key,
    CustomerTypeName nvarchar2(20) unique,
    DiscountRate number(3),
    Point number(10)
);

create table S_Reservation(
  ReservationID nvarchar2(10) primary key,
  DateTime nvarchar2(50),
  EmployeeID nvarchar2(10),
  RoomID number(10),
  Status nvarchar2(20)
);

create  table S_ReservationDetail
(
  ReservationDetailID nvarchar2(10) primary key,
  ReservationID nvarchar2(10),
  CustomerID nvarchar2(10)
);

create table S_Bill 
(
  BillID nvarchar2(10) primary key,
  DateTime nvarchar2(50),
  EmployeeID nvarchar2(10),
  CustomerId nvarchar2(10),
  Status nvarchar2(20)
);

create table S_BillDetail
(
  BillDetailID nvarchar2(10) primary key,
  BillID nvarchar2(10),
  RoomID nvarchar2(5)
);

create table S_Employee
(
  EmployeeID nvarchar2(10) primary key,
  Role nvarchar2(20),
  Password nvarchar2(20),
  FullName nvarchar2(30),
  Gender nvarchar2(20),
  PhoneNumber nvarchar2(10) unique,
  Address nvarchar2(50),
  Status nvarchar2(10)
);

create table S_Regulation
(
  RegulationID nvarchar2(4) primary key,
  RegulationName nvarchar2(50),
  Value number(10),
  Decription nvarchar2(50)
);



alter table S_Room add constraint S_FK_Room_RoomType foreign key (RoomTypeID) references S_RoomType(RoomTypeID) ;
alter table S_Customer add constraint S_FK_Customer_CustomerType foreign key (CustomerTypeID) references S_CustomerType(CustomerTypeID) ;
alter table S_ReservationDetail add constraint S_ReserDetail_Reser foreign key (ReservationID) references S_Reservation(ReservationID) ;
alter table S_ReservationDetail add constraint S_ReserDetail_Customer foreign key (CustomerID) references S_Customer(CustomerID) ;
alter table S_Reservation add constraint S_Reser_Room foreign key (ReservationID) references S_Room(RoomID);
alter table S_Reservation add constraint S_Reser_Employee foreign key (EmployeeID) references S_Employee(EmployeeID);
alter table S_BillDetail add constraint S_BillDetail_Bill foreign key (BillID) references S_Bill(BillID) ;
alter table S_BillDetail add constraint S_BillDetail_Room foreign key (RoomID) references S_Room(RoomID) ;
alter table S_Bill add constraint S_Bill_Employee foreign key (EmployeeID) references S_Employee(EmployeeID) ;



---------------------------------------------------------------------------------------------------------
----------------------/ Sequence /----------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------



create sequence S_Seq_Room
  MINVALUE 1001
  MAXVALUE 9999
  START WITH 1001
  INCREMENT BY 1;


create sequence S_Seq_RoomType
  MINVALUE 1
  MAXVALUE 99
  START WITH 1
  INCREMENT BY 1;

create sequence S_Seq_Customer
  MINVALUE 10000000
  MAXVALUE 99999999
  START WITH 10000001
  INCREMENT BY 1;

create sequence S_Seq_CustomerType
  MINVALUE 1
  MAXVALUE 99
  START WITH 1
  INCREMENT BY 1;

create sequence S_Seq_Reservation
  MINVALUE 10000001
  MAXVALUE 99999999
  START WITH 10000001
  INCREMENT BY 1;

create sequence S_Seq_ReservationDetail
  MINVALUE 10000001
  MAXVALUE 99999999
  START WITH 10000001
  INCREMENT BY 1;

create sequence S_Seq_Bill
  MINVALUE 10000001
  MAXVALUE 99999999
  START WITH 10000001
  INCREMENT BY 1;

create sequence S_Seq_BillDetail
  MINVALUE 10000001
  MAXVALUE 99999999
  START WITH 10000001
  INCREMENT BY 1;

create sequence S_Seq_Employee
  MINVALUE 10000001
  MAXVALUE 99999999
  START WITH 10000001
  INCREMENT BY 1;
  
create sequence S_Seq_Regulation
  MINVALUE 1
  MAXVALUE 99
  START WITH 1
  INCREMENT BY 1;




---------------------------------------------------------------------------------------------------------
----------------------/ Function /----------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------

-------------------------------- Room -----------------------------------------------------
-- Get status room is Empty                                                          OK
create or replace function S_func_GetRoomStatus (inp_RoomID nvarchar2)
return nvarchar2
is v_status nvarchar2(20);
begin
    select Status into v_status from S_Room where RoomID = inp_RoomID;
    return v_status;
EXCEPTION
    WHEN OTHERS THEN
        return '-1';
end;



-------------------------------- Customer ----------------------------------------------------
-- Get Customer Status                                                               OK
create or replace function S_func_GetCustomerStatus (inp_CustomerID nvarchar2)
return nvarchar2
is v_status nvarchar2(20);
begin
    select Status into v_status from S_Customer where CustomerID = inp_CustomerID;
    return v_status;
EXCEPTION
    WHEN OTHERS THEN
        return '-1';
end;


-- Get Discount Rate of Customer
create or replace function S_func_GetDiscountRate (inp_CustomerID nvarchar2)
return number
is v_rate number(3);
begin
    select DiscountRate into v_rate 
    from S_Customer, S_CustomerType 
    where S_Customer.CustomerTypeID = S_CustomerType.CustomerTypeID
        and CustomerID = inp_CustomerID;
    return v_rate;
EXCEPTION
    WHEN OTHERS THEN
        return '-1';
end;



-- Get Payment 
create or replace function S_func_GetPayment (inp_BillID nvarchar2)
return number
is  v_rate number(3);
begin
    
    select  RoomID, DateTime
    from    (
            select RoomID
            from S_Bill
                 inner join S_BillDetail
                 on S_Bill.BillID = S_BillDetail.BillID
            where S_Bill.BillID = inp_BillID;
            ) as Bill_BillDetail
            
            inner join 
            
            (
            select RoomID, DateTime
            from  S_Reservation
            ) Reser
            
            on Bill_BillDetail.RoomID = Reser.RoomID
            
EXCEPTION
    WHEN OTHERS THEN
        return '-1';
end;





---------------------------------------------------------------------------------------------------------
----------------------/ Procedure /----------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------

------------------------------------ RoomType ---------------------------------------------------------
-- Insert RoomType                                                                                      OK
create OR replace procedure S_proc_InsertRoomType (inp_RoomTypeName nvarchar2, inp_NumberBeds number, inp_RoomRate number)
is
begin
    insert into S_RoomType values('RT'||S_SEQ_ROOMTYPE.nextval,inp_RoomTypeName, inp_NumberBeds, inp_RoomRate);
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('IndertRoomType have been rolled back');
end;

call  proc_InsertRoomType('Single','1','2000000');
call  proc_InsertRoomType('Couple','1','3000000');
call  proc_InsertRoomType('Twin','2','3500000');
call  proc_InsertRoomType('Family','3','5000000');


-- Update RoomType                                                                                    OK
create OR replace procedure S_proc_UpdateRoomType (inp_RoomTypeID nvarchar2, inp_RoomTypeName nvarchar2, inp_NumberBeds number, inp_RoomRate number)
is
begin
    update S_RoomType
    set RoomTypeName = inp_RoomTypeName,
        NumberBeds = inp_NumberBeds,
        RoomRate = inp_RoomRate
    where RoomTypeID = inp_RoomTypeID;
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('UpdateRoomType have been rolled back');
end;



-- Update RoomType                                                                                    OK
create OR replace procedure S_proc_DeleteRoomType_byName (inp_RoomTypeName nvarchar2)
is
begin
    delete s_roomtype
    where RoomTypeName = inp_RoomTypeName;   
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('UpdateRoomType have been rolled back');
end;





------------------------------------ Room ---------------------------------------------------------

-- Insert Room                                                                                          OK
create OR replace procedure S_proc_InsertRoom (inp_RoomNumber  nvarchar2, inp_Flow number, inp_RoomTypeID nvarchar2, inp_Status nvarchar2)
is
begin
    insert into S_Room values('R'||S_SEQ_ROOM.nextval, inp_RoomNumber, inp_Flow, inp_RoomTypeID, inp_Status);
    commit;
end;

select * from S_room;
call proc_InsertRoom('0101','1','RT8','Empty');





------------------------------------ CustomerType ---------------------------------------------------------
-- Insert Customer Type                                                                                      OK
create OR replace procedure S_proc_InsertCustomerType (inp_CustomerTypeName nvarchar2, inp_Discountrate number, inp_Point number)
is
begin
    insert into S_CustomerType values('RT'||S_SEQ_CUSTOMERTYPE.nextval, inp_CustomerTypeName, inp_Discountrate, inp_Point);
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK; 
end;

select * from S_CustomerType;

call  S_proc_InsertCustomerType('Normal','0','0');
call  S_proc_InsertCustomerType('Vip','5','200');
call  S_proc_InsertCustomerType('Silver','10','500');
call  S_proc_InsertCustomerType('Gold','20','1000');
call  S_proc_InsertCustomerType('Diamond','30','2000');


-- Update CustomerType                                                                              OK
create OR replace procedure S_proc_UpdateCustomerType  (inp_CustomerTypeID nvarchar2, inp_CustomerTypeName nvarchar2, inp_DiscountRate number, inp_Point number)
is
begin
    update S_CustomerType
    set CustomerTypeName = inp_CustomerTypeName,
        DiscountRate = inp_DiscountRate ,
        Point = inp_Point
    where CustomerTypeID = inp_CustomerTypeID;
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('UpdateRoomType have been rolled back');
end;




-- Update RoomType                                                                                    OK
create OR replace procedure S_proc_UpdateRoomType (inp_RoomTypeID nvarchar2, inp_RoomTypeName nvarchar2, inp_NumberBeds number, inp_RoomRate number)
is
begin
    update S_RoomType
    set RoomTypeName = inp_RoomTypeName,
        NumberBeds = inp_NumberBeds,
        RoomRate = inp_RoomRate
    where RoomTypeID = inp_RoomTypeID;
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('UpdateRoomType have been rolled back');
end;




------------------------------------ Employee ---------------------------------------------------------

-- Insert Employee                                                                                      OK
create OR replace procedure S_proc_InsertEmployee (inp_Role nvarchar2, int_password nvarchar2, inp_FullName nvarchar2, inp_Gender nvarchar2, int_PhoneNumber nvarchar2, inp_Address nvarchar2)
is
begin
    insert into S_Employee values('EM'||S_SEQ_Employee.nextval, inp_Role, int_password, inp_FullName, inp_Gender, int_PhoneNumber, inp_Address);
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK; 
end;
/*
select * from S_Employee
call S_proc_InsertEmployee('Manager','123','Nguyen Quoc Hung','Male','0332098484','HCM');
*/

-- update                                                                                               OK
create or replace procedure S_proc_UpdateEmployee (inp_EmployeeID nvarchar2, inp_Role nvarchar2, int_Password nvarchar2, inp_FullName nvarchar2, inp_Gender nvarchar2, inp_PhoneNumber nvarchar2, inp_Address nvarchar2)
is
begin
    update S_Employee
    set Role = inp_Role,
        Password = int_Password,
        FullName = inp_FullName, 
        Gender = inp_Gender, 
        PhoneNumber = inp_PhoneNumber, 
        Address = inp_Address
    where EmployeeID = inp_EmployeeID;
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('UpdateRoomType have been rolled back');
end;
/*
select * from S_Employee;
call S_proc_UpdateEmployee('EM10000002','Manager','123','Nguyen Quoc Hung','Male','033209845','HCM');
*/


-- delete                                                                                           OK     
create or replace procedure S_proc_DeleteEmployee(inp_EmployeeID nvarchar2)
is
begin
    delete S_Employee where EmployeeID = inp_EmployeeID;
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('UpdateRoomType have been rolled back');
end;
/*
select * from S_Employee;
call S_proc_DeleteEmployee('EM10000002');
*/





------------------------------------ Regulation ---------------------------------------------------------

--Update
create or replace procedure S_proc_UpdateRegulation (inp_RegulationID nvarchar2, inp_Role nvarchar2, int_Password nvarchar2, inp_FullName nvarchar2, inp_Gender nvarchar2, inp_PhoneNumber nvarchar2, inp_Address nvarchar2)
is
begin
    
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('UpdateRoomType have been rolled back');
end;



------------------------------------ Reservation ---------------------------------------------------------

-- Insert Reservation                                                                                     OK
create OR replace procedure S_proc_InsertReservation (inp_DateTime date, inp_RoomID nvarchar2, inp_Status nvarchar2)
is
begin
    if(func_checkroomisempty(inp_roomid) = 'Empty') then
        insert into S_Reservation values('RE'||S_SEQ_RESERVATION.nextval, inp_DateTime, inp_RoomID, inp_Status);
    end if;
    commit;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('IndertRoomType have been rolled back');
end;



-- Update Reservation


-- Delete Reservation





------------------------------------ ReservationDetail ---------------------------------------------------------
--Insert

-- Update

-- Delete



------------------------------------ Bill---------------------------------------------------------
-- Insert
-- update
-- Delete


------------------------------------ BillDetail ---------------------------------------------------------
-- Insert
-- update
-- Delete



---------------------------------------------------------------------------------------------------------
----------------------/ Trigger /----------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------

--Kiem tra trang thai PHIEU THUE PHONG 
--// Kiem tra trang thai phong
-- Kiem tra khach hang co dang khong thue phong khong
-- cap nhat lai trang thai phieu thue tr??c do cua phong (ReserID, RoomID, status)

---------------------------------------------------------------------------------------------------------
--| Khi them phieu thue phong -> kiem tra trang thai phong va cap nhat trang thai cua phhieu thue truoc do
---------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER tg_Insert_Reservation
BEFORE INSERT 
ON S_Reservation
FOR EACH ROW
BEGIN
    --// Kiem tra trang thai phong
    --
    if(1<2) then    --// Neu trang thai phong la trong (Empty) -> cap nhat trang thai
        begin
            --// Cap nhat lai trang thai phong la da duoc thue (Rented)
            update S_Room set Status = 'Rented'
            where RoomID = :new.RoomID;
            
            --// Cap nhat lai trang thai cua phieu thue truoc do
            update S_Reservation set Status = 'old'
            where RoomID = :new.RoomID and Status = 'new'          
        end;
    else            --// Neu trang thai phong khong phai la trong -> huy giao tac 
        rollback;
    end if;
END;



-----------------------------------------------------------------------------------------------------------------------
--| Truoc khi xoa PHIEU THUE PHONG -> Kiem tra trang thai PHIEU THUE PHONG -> Xoa tat ca cac CHI TIET PHIEU THUE PHONG 
-----------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER tg_Delete_Reservation
BEFORE DELETE
ON S_Reservation
FOR EACH ROW
BEGIN
    --// Kiem tra trang thai PHIEU THUE PHONG 
    --
    if(1<2) then    --// Neu trang thai PHIEU THUE PHONG la moi(new) -> Xoa tat ca cac CHI TIET PHIEU THUE PHONG -> cap nhat lai trang thai cua PHIEU THUE PHONG truoc do
        begin
            DECLARE 
                v_ReserDetailID  S_ReservationDetail.ReservationDetailID%type; 
                CURSOR c_ReserDetail is SELECT ReservationDetailID 
                                        FROM S_ReservationDetail 
                                        WHERE ReservationID = :old.ReservationID; 
            BEGIN
                OPEN c_ReserDetail;
                LOOP
                FETCH c_ReserDetail into v_ReserDetailID;
                EXIT WHEN c_ReserDetail%notfound;
                      DELETE S_ReservationDetail WHERE ReservationDetailID = v_ReserDetailID;
                END LOOP;
                CLOSE c_ReserDetail;
                
                -- cap nhat lai phieu thue phong truoc do
            END; 
        end;
    else            --// Neu trang thai PHIEU THUE PHONG la cu(old) -> huy giao tac 
        rollback;
    end if;
END;



---------------------------------------------------------------------------------------------------------
--| Tr??c khi cap nhat  PHIEU THUE PHONG -> Kiem tra trang thai  PHIEU THUE PHONG va trang thai PHONG moi
---------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER tg_Update_Reservation
BEFORE UPDATE
ON S_Reservation
FOR EACH ROW
BEGIN
    --// Kiem tra trang thai PHIEU THUE PHONG
    --// Kiem tra trang thai ma phong moi
    --
    IF (1<3) THEN   --// Neu trang thai PHIEU THUE PHONG la moi(new) 
        BEGIN
            IF(1<2) THEN    --// Neu trang thai PHONG moi la trong(Empty) -> Cap nhat trang thai phong cu va moi
                BEGIN
                    update S_Room set Status = 'Empty' where RoomID = :old.RoomID;  --//Trang thai phong cu thanh 'Empty'
                    update S_Room set Status = 'Rented' where RoomID = :new.RoomID; --//Trang thai phong cu thanh 'Rented'
                    -- cap nhat lai trang thai phieu thue truoc do cua phong cu
                    -- cap nhat lai trang thai phieu thue truoc do cua phong moi
                END;
            ELSE            --// Neu trang thai PHONG moi khong phai la trong(Rented) -> Huy giao tac 
                rollback;
            END IF;
        END;
    ELSE            --// Neu trang thai PHIEU THUE PHONG la cu(old) -> Huy giao tac
        ROLLBACK;
    END IF;
END;




--------------------------------------------------------------------------------------------------------
--| Khi them chi tiet phieu thue(them khach hang trong phieu thue) -> cap nhat lai trang thai KHACH HANG
--------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER tg_Insert_ReservationDetail
BEFORE INSERT 
ON S_ReservationDetail
FOR EACH ROW
BEGIN
    -- Kiem tra khach hang co dang khong thue phong khong
    --
    if(1<2) then
        begin
            update S_Customer set Status = 'staying'
            where CustomerID = :new.CustomerID;
        end;
    end if;
END;




-----------------------------------------------------------------------------------------------------------------------------------------
--| khi xoa chi tiet phieu thue(xoa khach hang khoi phong) --> kiem tra trang thai phieu thue phong va cap nhat lai trang thai khach hang
-----------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER tg_Delete_ReservationDetail
BEFORE DELETE
ON S_ReservationDetail
FOR EACH ROW
BEGIN
    -- Kiem tra Reservation.Status
    -- 
    if(1<2) then  -- Neu la trang thai phieu thue phong la 'new' -> cap nhat trang thai cua khach hang thanh 'Not staying'
            update S_Customer set Status = 'not staying'
            where CustomerID = :old.CustomerID;
    else --Neu la trang thai phieu thue phong khong phai la 'new' -> huy giao tac 
        rollback;
    end if;
END;



----------------------------------------------------------------------------------------
--| Khi cap nhat lai reservationDetail -> cap nhat lai trang thai khach hang
----------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER tg_Update_ReservationDetail
BEFORE UPDATE
ON S_ReservationDetail
FOR EACH ROW
BEGIN
    -- Kiem trang thai phieu thue phong
    -- 
    if(1=1) then    -- Neu phieu thue la phieu moi -> cap nhat lai trang thai cua khach hang
        if(:new.CustomerID <> :old.Customer) then -- Neu thay doi ma khach hang -
            -- Kiem tra trang thai khach hang moi
            --
            if(1=1) then    -- Neu trang thai cua khach hang moi la 'not staying' -> cap nhat lai trang thai cua khach hang la 'staying'
                update S_Customer set Status = 'staying'
                where CustomerID = :new.CustomerID;
            else            -- Neu trang thai khach hang khac 'not staying' (khach hang da o mot phong khac) -> huy giao tac
                rollback;
        end if;
    else            -- Neu phieu thue la phieu cu -> huy giao tac
        rollback;
    end if;
END;



---------------------------------------------------------------------------------------------------------
--| Khi them phieu thue phong -> kiem tra trang thai phong va cap nhat trang thai cua phhieu thue truoc do
---------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER tg_Insert_Bill
BEFORE INSERT
ON S_Bill
FOR EACH ROW
BEGIN
    --// Kiem tra trang thai phong
    --
    if(1<2) then    --// Neu trang thai phong la trong (Empty) -> cap nhat trang thai
        begin
            --// Cap nhat lai trang thai phong la da duoc thue (Rented)
            update S_Room set Status = 'Rented'
            where RoomID = :new.RoomID;
            
            --// Cap nhat lai trang thai cua phieu thue truoc do
            update S_Reservation set Status = 'old'
            where RoomID = :new.RoomID and Status = 'new'          
        end;
    else            --// Neu trang thai phong khong phai la trong -> huy giao tac 
        rollback;
    end if;
END;







insert into S_Customer (Customerid) values('1');
insert into S_Customer (Customerid) values('2');

insert into S_Employee (employeeid) values ('1');

insert into S_RoomType(roomtypeid) values('1');
insert into S_Room(roomid, roomtypeid) values('1','1');
insert into S_Room(roomid, roomtypeid) values('2','1');

insert into S_Reservation (reservationid ,employeeid, roomid) values ('1','1','1');
insert into S_Reservation (reservationid ,employeeid, roomid) values ('2','1','1');

insert into S_ReservationDetail  values ('1','1');
insert into S_ReservationDetail  values ('1','2');


update S_ReservationDetail set reservationid = '2' where reservationid = '1'
