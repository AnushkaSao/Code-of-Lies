import discord
from discord.ext import commands
import random

TOKEN = 'bot token'
#your bots token is private and not to be shared 
#it will help you connect with the discord API :)


PREFIX = '!'

intents = discord.Intents.default()
intents.message_content = True
bot = commands.Bot(command_prefix=PREFIX, intents=intents)

questions = [
    {"question": "I have heard a lot about attoseconds in your universe, whom do I contact to see some beautiful attosecond pulses?", "answer": "Anne L'Huillier"},
    {"question": "sendnilbruoyhtiwuoyplehthgimdemhasiawayugruoy, ORSI htiw ni deknil si eh", "answer": "durins day", "image_path": None},
    {"question": "I wanna talk with princess cheeto, who has her?", "answer": "hugo", "image_path": None},
    {"question": "username:capycapybarabara9?", "answer": "hitler", "image_path": None},
    {"question": "'Now I Am Become Death, the Destroyer of Worlds.' who is one of the seven beings of the author?", "answer": "ashwatthama", "image_path": None}
]

@bot.event
async def on_ready():
    print(f'Logged in as {bot.user.name} ({bot.user.id})')
    print('------')

@bot.command(name='hello', help='Starts the quiz')
async def start_quiz(ctx):
    # Shuffle the questions for each user
    random.shuffle(questions)  

    # Set to keep track of asked questions for each user
    asked_questions = set()

    # Introduction
    await ctx.send("Hello! My name is Wall-E. Your carbon fingerprints suggest you're in a wrong universe. I can help you go back to your universe, but first, I want to know a little bit about your universe. 😍")

    correct_answers = 0  # Counter to track the number of correct answers

    while len(asked_questions) < len(questions):
        question_data = random.choice(questions)

   
        question_tuple = tuple(question_data.items())

        # Check if the question has been asked to the user before
        if question_tuple in asked_questions:
            continue

        asked_questions.add(question_tuple)

        await ctx.send(f"**Question:** {question_data['question']}")

        # Check if the question has an image path
        if 'image_path' in question_data and question_data['image_path'] is not None:
            image_path = question_data['image_path']
            with open(image_path, 'rb') as image_file:
                image = discord.File(image_file)
                await ctx.send(file=image)  # Send the image along with the question
                # i have not added any images in this bot but still for future purposes

        correct_answer = False
        while not correct_answer:
            user_response = await bot.wait_for('message', check=lambda m: m.author == ctx.author)

            if user_response.content.lower() == question_data['answer'].lower():
                await ctx.send("Correct!")
                correct_answer = True  # Set the flag to true and break out of the loop
            else:
                await ctx.send("Incorrect. Try again.")

        if correct_answer:
            correct_answers += 1  # Increment the counter for each correct answer

    if correct_answers == len(questions):  # Check if all questions were answered correctly
        await ctx.send("Yay, you passed the test! Here's your next clue: next clue link")
    else:
        await ctx.send("Sorry, you need to answer all questions correctly to proceed.")

bot.run(TOKEN)

'''go to https://discord.com/developers/applications to make a bot for yourself grant required permissions and generate a link for users and ur bot is ready to use :)
'''

