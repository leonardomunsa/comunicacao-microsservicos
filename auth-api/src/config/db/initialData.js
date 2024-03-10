import bcrypt from "bcrypt";
import User from "../../modules/user/model/User.js";

export async function createInitialData() {
    try {
        await User.sync({ force: true });
        
        let password = await bcrypt.hash("123456", 10);
        
        await User.create({
            name: 'User test',
            email: 'testuser@gmail.com',
            password
        });
    } catch (err) {
        console.log(err);
    }
}