import com.sun.nio.sctp.SendFailedNotification

fun main() {
    println("Hello!")

    var yacht = YachtRepair(SmsNotification(), UrgentRepair());
    yacht.SendNotification("Labas");
    println(yacht.CountRepairTime(3));
}

interface RepairType {
    fun CountRepairTime(damageLevel : Int): Int
    fun CountRepairMaterials(damageLevel : Int): Int
}

interface NotificationType {
    fun SendNotification( message : String)
}

class UrgentRepair () : RepairType
{
    override fun CountRepairTime(damageLevel : Int) : Int
    {
        return damageLevel * 5;
    }
    override fun CountRepairMaterials(damageLevel : Int) : Int
    {
        return damageLevel * 70;
    }

}

class OrdinaryRepair () : RepairType
{
    override fun CountRepairTime(damageLevel : Int) : Int
    {
        return damageLevel * 15;
    }
    override fun CountRepairMaterials(damageLevel : Int) : Int
    {
        return damageLevel * 40;
    }
}



class SmsNotification () : NotificationType
{
    override fun SendNotification( message : String)
    {
    println("///////////////////////////////////////////////////////////////////");
    println("///////////                  YOU GOT AN SMS                ////////");
    println(message);
    println("///////////////////////////////////////////////////////////////////");
    }
}

class EmailNotification () : NotificationType
{
    override fun SendNotification( message : String)
    {
        println("///////////////////////////////////////////////////////////////////");
        println("///////////                 YOU GOT AN EMAIL               ////////");
        println(message);
        println("///////////////////////////////////////////////////////////////////");
    }
}


class YachtRepair(val notificationDelegate: NotificationType, val repairDelegate: RepairType)
    : NotificationType by notificationDelegate, RepairType by repairDelegate {

//    override fun SendNotification(message: String)
//    {
//        return notificationDelegate.SendNotification(message);
//    }

    override fun CountRepairMaterials(damageLevel: Int): Int {
        return repairDelegate.CountRepairMaterials(damageLevel) * 3
    }

    override fun CountRepairTime(damageLevel: Int): Int {
        return repairDelegate.CountRepairTime(damageLevel) * 3
    }

    fun printColor ()
    {
        println("RED");
    }
}

class BoatRepair(val notificationDelegate: NotificationType, val repairDelegate: RepairType)
    : NotificationType by notificationDelegate, RepairType by repairDelegate {

//    override fun SendNotification(message: String)
////    {
////        return notificationDelegate.SendNotification(message);
////    }

    override fun CountRepairMaterials(damageLevel: Int): Int {
        return repairDelegate.CountRepairMaterials(damageLevel)
    }

    override fun CountRepairTime(damageLevel: Int): Int {
        return repairDelegate.CountRepairTime(damageLevel)
    }
}

class FerryRepair(val notificationDelegate: NotificationType, val repairDelegate: RepairType)
    : NotificationType by notificationDelegate, RepairType  {
    override fun CountRepairMaterials(damageLevel: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun CountRepairTime(damageLevel: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    override fun SendNotification(message: String)
//    {
//        return notificationDelegate.SendNotification(message);
//    }
//
//    override fun CountRepairMaterials(damageLevel: Int): Int {
//        return repairDelegate.CountRepairMaterials(damageLevel) * 7
//    }
//
//    override fun CountRepairTime(damageLevel: Int): Int {
//        return repairDelegate.CountRepairTime(damageLevel) * 8
//    }
}





